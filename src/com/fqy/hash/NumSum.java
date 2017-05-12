package com.fqy.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumSum {

	// public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
		int[] num = a.stream().mapToInt(i -> i).toArray();
		int target = b;

		ArrayList<ArrayList<Integer>> resSet = new ArrayList<ArrayList<Integer>>(num.length / 4); // avoid
																									// resizing
																									// cost
		if (num.length < 4)
			return resSet;
		Arrays.sort(num);
		for (int i = 0; i < num.length - 3; ++i) {
			// skip duplicates
			if (i > 0 && num[i] == num[i - 1])
				continue;
			for (int j = i + 1; j < num.length - 2; ++j) {
				// skip duplicates
				if (j > i + 1 && num[j] == num[j - 1])
					continue;
				// use two pointers to find the rest of two elements
				int ss = j + 1, ee = num.length - 1;
				while (ss < ee) {
					int sum = num[i] + num[j] + num[ss] + num[ee];
					if (sum < target) {
						ss++;
					} else if (sum > target) {
						ee--;
					} else { // found one quadruplet
						ArrayList<Integer> res = new ArrayList<Integer>(4);
						res.add(num[i]);
						res.add(num[j]);
						res.add(num[ss]);
						res.add(num[ee]);
						resSet.add(res);
						// move forward and skip duplicates
						do {
							ss++;
						} while (ss < ee && num[ss] == num[ss - 1]);
						do {
							ee--;
						} while (ss < ee && num[ee] == num[ee + 1]);
					}
				} // end-while
			}
		}
		return resSet;
	}

	/**
	 * Definition for singly-linked list with a random pointer. class
	 * RandomListNode { int label; RandomListNode next, random;
	 * RandomListNode(int x) { this.label = x; } };
	 */
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public class Solution {

		private HashMap<RandomListNode, RandomListNode> hashMap;

		public RandomListNode copyRandomList(RandomListNode head) {
			RandomListNode node, newHead, newNode;
			hashMap = new HashMap<>();
			node = head;
			newHead = null;
			while (node != null) {
				newNode = new RandomListNode(node.label);
				if (newHead == null)
					newHead = newNode;
				hashMap.put(node, newNode);
				node = node.next;
			}
			for (Map.Entry<RandomListNode, RandomListNode> entry : hashMap.entrySet()) {
				node = entry.getKey();
				newNode = entry.getValue();
				if (node.next != null) {
					newNode.next = hashMap.get(node.next);
				}
				if (node.random != null) {
					newNode.random = hashMap.get(node.random);
				}
			}
			return newHead;
		}
	}

}
