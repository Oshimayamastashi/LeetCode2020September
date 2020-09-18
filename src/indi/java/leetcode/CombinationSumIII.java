package indi.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium, Speed 100.00% Memory 90.53%
 */
public class CombinationSumIII {

	public static void main(String[] args) {
		combinationSum3(3, 7);
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> a = new ArrayList<>();
		refind(k, n, 0, a, ans);

		return ans;
	}

	private static void refind(int k, int sum, int start, List<Integer> c, List<List<Integer>> ans) {

		if (sum > 0 && k == c.size()) {
			return;
		}

		if (sum == 0 && k == c.size()) {
			List<Integer> a = new ArrayList<>(c);
			ans.add(a);
		}

		for (int x = start + 1; x < 10; x++) {
			c.add(x);
			refind(k, sum - x, x, c, ans);
			c.remove(c.size() - 1);
		}
	}

}
