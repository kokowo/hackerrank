package yush.data.tree;

/*
 * Given a binary tree, determine if it is a valid Binary Search Tree (BST).
 */
public class ValidateBst {

	// recursive
	public boolean isValidBSTRecursive(TreeNode root) {
		return valid(root, null, null);
	}

	private boolean valid(TreeNode p, Integer low, Integer high) {
		if (p == null)
			return true;
		return (low == null || p.val > low) && (high == null || p.val < high) && valid(p.left, low, p.val)
				&& valid(p.right, p.val, high);
	}

	// In-order traversal
	private TreeNode prev;
	public boolean isValidBST(TreeNode root) {
		prev = null;
		return isMonotonicIncreasing(root);
	}

	private boolean isMonotonicIncreasing(TreeNode p) {
		if (p == null)
			return true;
		if (isMonotonicIncreasing(p.left)) {
			if (prev != null && p.val <= prev.val)
				return false;
			prev = p;
			return isMonotonicIncreasing(p.right);
		}
		return false;
	}

}
