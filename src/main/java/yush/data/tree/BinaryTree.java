package yush.data.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	TreeNode root;

	BinaryTree() {
		root = null;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(4);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(5);
		tree.root.left.left = new TreeNode(1);
		tree.root.left.right = new TreeNode(3);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printDepthFirstPreorder(tree.root);

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printDepthFirstInorder(tree.root);

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printDepthFirstPostorder(tree.root);
		
		System.out.println("\nLevel Order (Breadth-first) traversal of binary tree is ");
		tree.printLevelOrder(tree.root);
		
		
	}

	void printDepthFirstPreorder(TreeNode node) {
		if (node == null)
			return;

		/* first print data of node */
		System.out.print(node.val + " ");

		/* then recur on left sutree */
		printDepthFirstPreorder(node.left);

		/* now recur on right subtree */
		printDepthFirstPreorder(node.right);
	}

	void printDepthFirstInorder(TreeNode node) {
		if (node == null)
			return;

		/* first recur on left child */
		printDepthFirstInorder(node.left);

		/* then print the data of node */
		System.out.print(node.val + " ");

		/* now recur on right child */
		printDepthFirstInorder(node.right);
	}

	void printDepthFirstPostorder(TreeNode node) {
		if (node == null)
			return;

		// first recur on left subtree
		printDepthFirstPostorder(node.left);

		// then recur on right subtree
		printDepthFirstPostorder(node.right);

		// now deal with the node
		System.out.print(node.val + " ");
	}
	
	void printLevelOrder(TreeNode node) {
		if (node == null)
			return;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(node);
		
		while (!q.isEmpty()) {
			TreeNode n = q.poll();
			System.out.print(n.val + " ");
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
		}
	}

}
