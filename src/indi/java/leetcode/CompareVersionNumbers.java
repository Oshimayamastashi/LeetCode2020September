package indi.java.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO: too slow, need improve 2020/9/10, Java
 */
public class CompareVersionNumbers {

	public static void main(String[] args) {
		System.out.println(compareVersion("0.1", "1.1"));
	}

	public static int compareVersion(String version1, String version2) {
		List<Integer> versions1 = getVersionList(version1);
		List<Integer> versions2 = getVersionList(version2);

		int size = versions1.size() > versions2.size() ? versions1.size() : versions2.size();

		for (int i = 0; i < size; i++) {
			Integer v1 = 0;
			Integer v2 = 0;

			while (i < versions1.size()) {

			}

//			Integer v1 = getVersionByIndex(versions1, i);
//			Integer v2 = getVersionByIndex(versions2, i);

			if (v1 > v2) {
				return 1;
			} else if (v1 < v2) {
				return -1;
			}
		}

		return 0;
	}

	private static Integer getVersionByIndex(List<Integer> versions, int index) {

		if (versions.size() > index) {
			return versions.get(index);
		}

		return 0;
	}

	private static List<Integer> getVersionList(String version) {

		return Arrays.stream(version.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());
	}
}
