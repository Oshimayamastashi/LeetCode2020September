package indi.java.leetcode;

import java.util.Arrays;

/**
 * Medium, Runtime: 4 ms(98.32%) Memory Usage: 38.7 MB(97.50%)
 *
 */
public class LargestNumber {

	public String largestNumber(int[] nums) {

		int l = nums.length;

		String[] strs = new String[l];

		for (int i = 0; i < l; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strs, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));
		StringBuilder sb = new StringBuilder();

		for (String str : strs) {
			sb.append(str);
		}

		if (sb.charAt(0) == '0') {
			return "0";
		}

		return sb.toString();
	}

}
