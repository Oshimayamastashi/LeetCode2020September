package indi.java.leetcode;

/**
 * Easy, Runtime: 1 ms(99.41%) Memory Usage: 37.9 MB(53.77%)
 *
 */
public class FindTheDifference {

	public char findTheDifference(String s, String t) {
		int diff = t.charAt(0);
		for (int i = 0; i < s.length(); i++) {
			diff += t.charAt(i + 1) - s.charAt(i);
		}

		return (char) diff;
	}

}
