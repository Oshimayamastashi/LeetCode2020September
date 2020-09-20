package indi.java.leetcode;

/**
 * Medium, Runtime: 1 ms(91.46%) Memory Usage: 39.6 MB(37.65%)
 */
public class MaximumProductSubarray {

	public int maxProduct(int[] nums) {

		if (nums.length < 1) {
			return 0;
		}

		int max = nums[0];

		int curMin = 1;
		int curMax = 1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				int temp = curMax;
				curMax = curMin;
				curMin = temp;
			}

			curMax = Math.max(curMax * nums[i], nums[i]);
			curMin = Math.min(curMin * nums[i], nums[i]);
			max = Math.max(curMax, max);
		}

		return max;
	}
}
