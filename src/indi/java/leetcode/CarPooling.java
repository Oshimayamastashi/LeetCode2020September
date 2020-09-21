package indi.java.leetcode;

/**
 * Medium, Runtime: 0 ms(100%) Memory Usage: 39.3 MB(59.46%)
 */
public class CarPooling {

	public boolean carPooling(int[][] trips, int capacity) {

		int[] drives = new int[1001];
		int minStart = 0;
		int maxEnd = 0;

		for (int[] trip : trips) {
			drives[trip[1]] += trip[0];
			drives[trip[2]] -= trip[0];

			minStart = Math.min(minStart, trip[1]);
			maxEnd = Math.max(maxEnd, trip[2]);
		}

		int cur = 0;
		for (int i = minStart; i < maxEnd; i++) {
			cur += drives[i];
			if (cur > capacity) {
				return false;
			}
		}

		return true;
	}
}
