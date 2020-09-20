package indi.java.leetcode;

/**
 * Medium, Runtime: 1 ms(91.48%) Memory Usage: 37.5 MB(44.17%)
 */
public class CompareVersionNumbers {

	public int compareVersion(String version1, String version2) {
		int i1 = 0;
		int i2 = 0;

		while (i1 < version1.length() || i2 < version2.length()) {

			StringBuilder v1 = new StringBuilder();
			StringBuilder v2 = new StringBuilder();

			while (i1 < version1.length() && version1.charAt(i1) != '.') {
				v1.append(version1.charAt(i1));
				i1++;
			}

			while (i2 < version2.length() && version2.charAt(i2) != '.') {
				v2.append(version2.charAt(i2));
				i2++;
			}

			int v11 = getVersion(v1);
			int v22 = getVersion(v2);

			if (v11 > v22) {
				return 1;
			} else if (v11 < v22) {
				return -1;
			}

			i1++;
			i2++;
		}

		return 0;
	}

	private Integer getVersion(StringBuilder sb) {
		if (sb.toString().equals("")) {
			return 0;
		}

		return Integer.parseInt(sb.toString());
	}
}
