package indi.java.leetcode;

/**
 * Medium, Runtime: 0 ms(100%) Memory Usage: 39.6 MB(77.43%)
 */
public class GasStation {

	public static void main(String[] args) {
		int[] gas = { 6, 6, 6, 6, 100 };
		int[] cost = { 3, 4, 100, 1, 1 };

		canCompleteCircuit(gas, cost);
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {

		int[] remains = new int[gas.length];
		int total = 0;

		for (int i = 0; i < gas.length; i++) {
			int remain = gas[i] - cost[i];
			remains[i] = remain;
			total += remain;
		}

		if (total < 0) {
			return -1;
		}

		int i = 0;
		while (i < gas.length) {

			while (remains[i] < 0) {
				i++;
			}

			int count = 0;
			int pos = i;
			int cur = 0;
			while (count < gas.length) {
				cur += remains[pos];

				if (cur < 0) {
					break;
				}
				count++;
				pos = (pos + 1) % gas.length;
			}

			if (count == gas.length) {
				return i;
			}

			while (remains[i] > 0) {
				i++;
			}
		}

		return -1;
	}

}
