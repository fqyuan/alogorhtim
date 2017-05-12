package com.fqy.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Smaller {
	public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		// Traverse all arr elements
		for (int i = 0; i < arr.size(); i++) {
			// Keep moving top elements from stack while the top element is
			// greater than of equal to arr[i]
			while (!stack.isEmpty() && stack.peek() >= arr.get(i))
				stack.pop();
			// If all elements in S were greater than arr[i]
			if (stack.isEmpty())
				arrayList.add(-1);
			else {
				// Else get the nearest smaller element
				arrayList.add(stack.peek());
			}
			// Push this element
			stack.push(arr.get(i));
		}
		return arrayList;
	}

	/*
	 * Note: Elements in a subset must be in non-descending order. The solution
	 * set must not contain duplicate subsets. Also, the subsets should be
	 * sorted in ascending ( lexicographic ) order. The list is not necessarily
	 * sorted.
	 */
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
		if (a.size() == 0)
			return null;
		Collections.sort(a);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		// Add emtpy set
		result.add(new ArrayList<>());
		for (int i = 0; i < a.size(); i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
			// Get sets that are already in result
			for (ArrayList<Integer> arr : result) {
				temp.add(new ArrayList<Integer>(arr));
			}
			// Add a[i] to existing sets
			for (ArrayList<Integer> arr : temp) {
				arr.add(a.get(i));
			}
			// Add S[i] to only as a set
			ArrayList<Integer> single = new ArrayList<>();
			single.add(a.get(i));
			temp.add(single);
			result.addAll(temp);
		}

		return result;

	}

	public static ArrayList<ArrayList<Integer>> subsets1(ArrayList<Integer> a) {
		if (a == null)
			return null;
		Collections.sort(a);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < a.size(); i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> list : result) {
				temp.add(new ArrayList<Integer>(list));
			}
			// System.out.println(" temp has: " );
			// for(ArrayList<Integer> list : temp)
			// System.out.println("\t" + list);
			for (ArrayList<Integer> list : temp) {
				list.add(a.get(i));
			}
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(a.get(i));
			temp.add(single);
			result.addAll(temp);
		}

		result.add(0, new ArrayList<Integer>());
		// Collections.sort(result);
		Collections.sort(result, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				int an = a.size();
				int bn = b.size();
				for (int i = 0; i < Math.min(an, bn); i++) {
					int cmp = Integer.compare(a.get(i), b.get(i));
					if (cmp != 0)
						return cmp;
				}
				return Integer.compare(a.size(), b.size());
			}
		});
		return result;
	}

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(S);
		res.add(tmp);
		dfs(res, tmp, S, 0);
		return res;
	}

	public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] S, int pos) {
		for (int i = pos; i <= S.length - 1; i++) {
			tmp.add(S[i]);
			res.add(new ArrayList<Integer>(tmp));
			dfs(res, tmp, S, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}

	public List<String> letterCombinations(String digits) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		map.put(0, "");

		ArrayList<String> result = new ArrayList<String>();

		if (digits == null || digits.length() == 0)
			return result;

		ArrayList<Character> temp = new ArrayList<Character>();
		getString(digits, temp, result, map);

		return result;
	}

	public void getString(String digits, ArrayList<Character> temp, ArrayList<String> result,
			HashMap<Integer, String> map) {
		if (digits.length() == 0) {
			char[] arr = new char[temp.size()];
			for (int i = 0; i < temp.size(); i++) {
				arr[i] = temp.get(i);
			}
			result.add(String.valueOf(arr));
			return;
		}

		Integer curr = Integer.valueOf(digits.substring(0, 1));
		String letters = map.get(curr);
		for (int i = 0; i < letters.length(); i++) {
			temp.add(letters.charAt(i));
			getString(digits.substring(1), temp, result, map);
			temp.remove(temp.size() - 1);
		}
	}

}
