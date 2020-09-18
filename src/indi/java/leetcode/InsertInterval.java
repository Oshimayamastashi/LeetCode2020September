package indi.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Hard, Speed 98.83% Memory 38.30%
 */
public class InsertInterval {

	public int[][] insert(int[][] intervals, int[] newInterval) {

		List<int[]> result = new ArrayList<>();

		int i = 0;
		while (i < intervals.length && intervals[i][1] < newInterval[0]) {
			result.add(intervals[i]);
			i++;
		}

		if (i < intervals.length) {
			newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
			while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
				newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
				i++;
			}
			result.add(newInterval);

			while (i < intervals.length) {
				result.add(intervals[i]);
				i++;
			}
		} else {
			result.add(newInterval);
		}

		return result.toArray(new int[result.size()][]);
	}
}
