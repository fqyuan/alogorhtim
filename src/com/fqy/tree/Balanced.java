package com.fqy.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
/*
 * class TreeNode { int val; TreeNode left; TreeNode right;
 * 
 * TreeNode(int x) { val = x; } }
 */
public class Balanced {
	public int height(TreeNode root) {
		// Base case tree is empty
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public boolean isBalanced(TreeNode a) {
		int lheight; // height of left subtree
		int rheight; // height of right subtree
		// If tree is empty then return true
		if (a == null)
			return true;
		// Get the height of left and right subtrees
		lheight = height(a.left);
		rheight = height(a.right);
		if (Math.abs(lheight - rheight) <= 1 && isBalanced(a.left) && isBalanced(a.right))
			return true;
		// If we reach here then tree is not height-balanced
		return false;
	}

	public int isBalanced1(TreeNode a) {
		int lheight; // height of left subtree
		int rheight; // height of right subtree
		// If tree is empty then return true
		if (a == null)
			return 1;
		// Get the height of left and right subtrees
		lheight = height(a.left);
		rheight = height(a.right);
		if (Math.abs(lheight - rheight) <= 1 && isBalanced1(a.left) == 1 && isBalanced1(a.right) == 1)
			return 1;
		// If we reach here then tree is not height-balanced
		return 0;
	}

	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
		// public TreeNode buildTree(int[] inorder, int[] postorder) {

		if (inorder.size() == 0 || postorder.size() == 0)
			return null;
		int ip = inorder.size() - 1;
		int pp = postorder.size() - 1;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = null;
		TreeNode root = new TreeNode(postorder.get(pp));
		stack.push(root);
		pp--;

		while (pp >= 0) {
			while (!stack.isEmpty() && stack.peek().val == inorder.get(ip)) {
				prev = stack.pop();
				ip--;
			}
			TreeNode newNode = new TreeNode(postorder.get(pp));
			if (prev != null) {
				prev.left = newNode;
			} else if (!stack.isEmpty()) {
				TreeNode currTop = stack.peek();
				currTop.right = newNode;
			}
			stack.push(newNode);
			prev = null;
			pp--;
		}

		return root;
	}
}
