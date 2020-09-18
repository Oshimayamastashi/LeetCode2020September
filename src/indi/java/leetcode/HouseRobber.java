package indi.java.leetcode;

/**
 * Easy, Runtime: 0 ms Memory Usage: 39.2 MB
 */
public class HouseRobber {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1 };

		rob(arr);
	}

	public static int rob(int[] nums) {

		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		}

		nums[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
		}

		return nums[nums.length - 1];
	}
}
