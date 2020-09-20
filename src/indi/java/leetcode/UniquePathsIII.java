package indi.java.leetcode;

/**
 * Hard, Runtime: 0 ms(100%) Memory Usage: 36.3 MB(99.01%)
 */
public class UniquePathsIII {

	private int endX;
	private int endY;
	private int needWalk;
	private int ans;

	private int gridH;
	private int gridW;

	public int uniquePathsIII(int[][] grid) {

		int startX = 0;
		int startY = 0;
		needWalk = 0;
		ans = 0;

		gridH = grid.length;
		gridW = grid[0].length;

		for (int i = 0; i < grid.length; i++) {
			for (int x = 0; x < grid[i].length; x++) {
				if (grid[i][x] >= 0) {
					needWalk++;
				}

				if (grid[i][x] == 1) {
					startX = i;
					startY = x;
				} else if (grid[i][x] == 2) {
					endX = i;
					endY = x;
				}
			}
		}

		grid[startX][startY] = -1;
		back(grid, startX, startY, 1);

		return ans;
	}

	private void back(int[][] grid, int curX, int curY, int walk) {

		if (curX == endX && curY == endY) {
			if (walk == needWalk) {
				ans++;
			}
			return;
		}

		if (curX > 0 && grid[curX - 1][curY] >= 0) {
			int v = grid[curX - 1][curY];
			grid[curX - 1][curY] = -1;
			back(grid, curX - 1, curY, walk + 1);
			grid[curX - 1][curY] = v;
		}

		if (curX + 1 < gridH && grid[curX + 1][curY] >= 0) {
			int v = grid[curX + 1][curY];
			grid[curX + 1][curY] = -1;
			back(grid, curX + 1, curY, walk + 1);
			grid[curX + 1][curY] = v;
		}

		if (curY > 0 && grid[curX][curY - 1] >= 0) {
			int v = grid[curX][curY - 1];
			grid[curX][curY - 1] = -1;
			back(grid, curX, curY - 1, walk + 1);
			grid[curX][curY - 1] = v;
		}

		if (curY + 1 < gridW && grid[curX][curY + 1] >= 0) {
			int v = grid[curX][curY + 1];
			grid[curX][curY + 1] = -1;
			back(grid, curX, curY + 1, walk + 1);
			grid[curX][curY + 1] = v;
		}
	}

}
