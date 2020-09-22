package indi.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {

	/**
	 * Medium, Runtime: 3 ms(54.81%) Memory Usage: 43.7 MB(41.42%) 
	 * ## Not the Correctest Way
	 */
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		if (nums.length == 0) {
			return ans;
		}

		Arrays.sort(nums);

		int times = nums.length / 3;
		int last = nums[0];
		int count = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == last) {
				count++;
			} else {
				if (count > times) {
					ans.add(last);
				}

				last = nums[i];
				count = 1;
			}
		}

		if (count > times) {
			ans.add(last);
		}

		return ans;
	}

}
