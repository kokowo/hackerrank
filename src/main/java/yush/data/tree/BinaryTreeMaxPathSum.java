package yush.data.tree;

/*
 * Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree, can have negative
 */
public class BinaryTreeMaxPathSum {

	private int maxSum;

	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		findMax(root);
		return maxSum;
	}

	private int findMax(TreeNode p) {
		if (p == null)
			return 0;
		int left = findMax(p.left);
		int right = findMax(p.right);
		// negative removed
		maxSum = Math.max(p.val + left + right, maxSum);
		int ret = p.val + Math.max(left, right);
		
		// remove negative
		return ret > 0 ? ret : 0;
	}

}
