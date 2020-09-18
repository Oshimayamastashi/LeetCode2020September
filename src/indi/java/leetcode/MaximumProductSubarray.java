package indi.java.leetcode;

/**
 * TODO: Not Finish
 *
 */
public class MaximumProductSubarray {

	public static void main(String[] args) {
		int[] arr = { 0, -7, 0, -8, 0 };
		System.out.println(maxProduct(arr));

	}

	public static int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE;

		int curMin = 1;
		int curMax = 1;
		boolean flag = false;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				curMax *= nums[i];
				curMin = Math.min(curMin * nums[i], 1);
				flag = true;
			} else if (nums[i] < 0) {
				int temp = curMax;
				curMax = Math.max(curMin * nums[i], 1);
				curMin = temp * nums[i];
			} else {
				curMin = 1;
				curMax = 1;
			}

			if (max < curMax) {
				max = curMax;
			}
		}

		if (!flag && max == 1) {
			return 0;
		}

		return max;
	}

}
