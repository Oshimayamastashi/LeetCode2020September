package indi.java.leetcode;

/**
 * Medium, Runtime: 0 ms(100.00%) Memory Usage: 37.3 MB(61.72%)
 */
public class RobotBoundedInCircle {

	public boolean isRobotBounded(String instructions) {

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int x = 0;
		int y = 0;
		int dir = 0;

		for (char i : instructions.toCharArray()) {

			if (i == 'L') {
				dir = (dir + 3) % 4;
			} else if (i == 'R') {
				dir = (dir + 1) % 4;
			} else {
				y += dy[dir];
				x += dx[dir];
			}
		}

		return (y == 0 && x == 0) || dir != 0;
	}
}
