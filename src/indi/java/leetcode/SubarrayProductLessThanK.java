package indi.java.leetcode;

/**
 * Medium, Runtime: 6 ms(100.00%) Memory Usage: 47.9 MB(99.90%)
 */
public class SubarrayProductLessThanK {

	public int numSubarrayProductLessThanK(int[] nums, int k) {

		int[] dp = new int[nums.clone().length];
		int[] p = new int[nums.clone().length];

		int ans = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + 1 < nums.length && nums[i] * p[i + 1] < k) {
				dp[i] = dp[i + 1] + 1;
				p[i] = p[i + 1] * nums[i];
				ans += dp[i];
			} else {
				int cur = 1;
				int count = 0;

				for (int x = i; x < nums.length; x++) {
					if (cur * nums[x] >= k) {
						break;
					}
					count++;
					cur *= nums[x];
				}

				dp[i] = count;
				p[i] = cur;
				ans += dp[i];
			}
		}

		return ans;
	}
}
