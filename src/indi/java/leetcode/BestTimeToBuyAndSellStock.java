package indi.java.leetcode;

/**
 * Easy, Runtime: 1 ms(99.23%) Memory Usage: 39.1 MB(93.85%)
 */
public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {

		int i = 0;
		int ans = 0;
		int minDownFall = Integer.MAX_VALUE;

		while (i < prices.length) {
			while (i + 1 < prices.length && prices[i] > prices[i + 1]) {
				i++;
			}
			minDownFall = Math.min(minDownFall, prices[i]);

			while (i + 1 < prices.length && prices[i] < prices[i + 1]) {
				i++;
			}
			ans = Math.max(ans, prices[i] - minDownFall);
			i++;
		}

		return ans;
	}

	public int maxProfit2(int[] prices) {
		if (prices.length <= 1)
			return 0;
		int[] dp = new int[prices.length];
		dp[prices.length - 1] = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			dp[i] = Math.max(prices[i], dp[i + 1]);
		}
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			int currMax = dp[i] - prices[i];
			max = Math.max(currMax, max);
		}
		return max;
	}
}
