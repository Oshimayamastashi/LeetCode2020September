package indi.java.leetcode;

/**
 * Hard, Runtime: 0 ms(100.00%) Memory Usage: 36.7 MB(98.23%)
 */
public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		int l = nums.length;
		boolean[] s = new boolean[l];

		for (int num : nums) {
			if (0 < num && num <= l) {
				s[num - 1] = true;
			}
		}

		for (int i = 0; i < l; i++) {
			if (!s[i]) {
				return i + 1;
			}
		}

		return l + 1;
	}
}
