package indi.java.leetcode;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Medium, Runtime: 7 ms(54.03%) Memory Usage: 39.4 MB(72.31%)
 */
public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {

		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		Set<String> wordSet = wordDict.stream().collect(Collectors.toSet());

		for (int i = 0; i < s.length() + 1; i++) {
			for (int x = 0; x < i; x++) {
				String s1 = s.substring(x, i);
				if (dp[x] && wordSet.contains(s1)) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}
}
