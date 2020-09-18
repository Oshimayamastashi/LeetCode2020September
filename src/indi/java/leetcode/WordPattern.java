package indi.java.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {

	public static void main(String[] args) {
		wordPattern("abba", "dog dog dog dog");
	}

	public static boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");

		if (words.length != pattern.length()) {
			return false;
		}

		Map<String, Integer> wMap = new HashMap<>();
		String[] pMap = new String[26];

		for (int i = 0; i < pattern.length(); i++) {
			int index = pattern.charAt(i) - 'a';
			if (Objects.isNull(pMap[index]) && Objects.isNull(wMap.get(words[i]))) {
				pMap[index] = words[i];
				wMap.put(words[i], index);
				continue;
			} else if (Objects.isNull(pMap[index]) && Objects.nonNull(wMap.get(words[i]))) {
				return false;
			}

			if (Objects.nonNull(pMap[index]) && !pMap[index].equals(words[i])) {
				return false;
			}

		}

		return true;
	}

}
