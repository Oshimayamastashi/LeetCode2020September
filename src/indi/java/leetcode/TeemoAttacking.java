package indi.java.leetcode;

/**
 * Medium, Runtime: 1 ms(100%) Memory Usage: 41.1 MB(97.23%)
 */
public class TeemoAttacking {

	public int findPoisonedDuration(int[] timeSeries, int duration) {
		int pTime = 0;
		int last = -duration;

		for (int time : timeSeries) {
			if (last + duration <= time) {
				pTime += duration;
			} else {
				pTime += (time - last);
			}

			last = time;
		}

		return pTime;
	}
}
