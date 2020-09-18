package indi.java.leetcode;

import java.util.Objects;

public class SumOfRootToLeafBinaryNumbers {

	public int sumRootToLeaf(TreeNode root) {

		return getLeafValue(root, 0);
	}

	private int getLeafValue(TreeNode root, int val) {

		int curVal = val * 2 + root.val;

		if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
			return curVal;
		}

		int total = 0;

		if (Objects.nonNull(root.left)) {
			total += getLeafValue(root.left, curVal);
		}

		if (Objects.nonNull(root.right)) {
			total += getLeafValue(root.right, curVal);
		}

		return total;
	}

	public class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
