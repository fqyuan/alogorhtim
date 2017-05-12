package com.fqy.tree;

import java.util.ArrayList;
import java.util.Stack;

/*
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
*/
public class Traversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				// add() is allowed because stack is a subclass of Vector
				// Append the specific element to the end of the vector
				// stack.add(cur);
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			list.add(cur.val);
			cur = cur.right;
		}
		return list;
	}
}
