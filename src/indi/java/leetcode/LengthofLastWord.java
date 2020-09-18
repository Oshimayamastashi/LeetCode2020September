package indi.java.leetcode;

/**
 * Easy, Speed 100.00%(0 ms) Memory 82.00%(37.5 MB)
 */
public class LengthofLastWord {

	public int lengthOfLastWord(String s) {

		int max = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				if (max > 0) {
					break;
				} else {
					max = -1;
				}
			}
			max++;
		}

		return max;
	}
}
