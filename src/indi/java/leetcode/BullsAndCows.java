package indi.java.leetcode;

/**
 * Easy, Speed 100.00% Memory 99.48%
 */
public class BullsAndCows {

	public static void main(String[] args) {
		getHint("1123", "0111");
	}

	public static String getHint(String secret, String guess) {

		int a = 0;
		int b = 0;

		int[] map = new int[10];

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < secret.length(); i++) {
			char ans = secret.charAt(i);
			if (guess.charAt(i) == ans) {
				a++;
			} else {
				map[ans - '0']++;
			}
		}

		for (int i = 0; i < secret.length(); i++) {
			char ans = guess.charAt(i);
			if (ans != secret.charAt(i) && map[ans - '0'] > 0) {
				b++;
				map[ans - '0']--;
			}
		}

		return sb.append(a).append("A").append(b).append("B").toString();
	}

}
