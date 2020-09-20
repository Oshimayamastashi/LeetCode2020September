package indi.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Medium, Runtime: 0 ms(100%) Memory Usage: 38.8 MB(8.98%)
 */
public class SequentialDigits {

	public List<Integer> sequentialDigits(int low, int high) {

		List<Integer> ans = new ArrayList<>();

		for (int i = 1; i < 10; i++) {
			getSequentDigit(ans, i, low, high);
		}

		Collections.sort(ans);

		return ans;
	}

	private void getSequentDigit(List<Integer> ans, int cur, int low, int high) {

		if (cur > high) {
			return;
		}

		if (cur >= low) {
			ans.add(cur);
		}

		int last = cur % 10;
		if (last == 9) {
			return;
		}
		cur = cur * 10 + last + 1;
		getSequentDigit(ans, cur, low, high);
	}
}
