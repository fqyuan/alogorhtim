package com.fqyuan.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Sprial {
	public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int row = a.size();
		int col = a.get(0).size();

		int rowStart = 0;
		int rowEnd = row - 1;
		int colStart = 0;
		int colEnd = col - 1;
		while (rowStart <= rowEnd && colStart <= colEnd) {
			// Top
			for (int i = colStart; i <= colEnd; i++)
				result.add(a.get(rowStart).get(i));
			rowStart++;

			// Right
			for (int i = rowStart; i <= rowEnd; i++)
				result.add(a.get(i).get(colEnd));
			colEnd--;
			// The operation is to avoid duplication here.
			// Bottom
			if (rowStart <= rowEnd) {
				for (int i = colEnd; i >= colStart; i--)
					result.add(a.get(rowEnd).get(i));
			}
			rowEnd--;
			// Left
			if (colStart <= colEnd) {
				for (int i = rowEnd; i >= rowStart; i--)
					result.add(a.get(i).get(colStart));
			}
			colStart++;
		}
		return result;
		// StringBuilder sb =new StringBuilder();
		// sb.len
	}

	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		ArrayList<Integer> list = new ArrayList<>();
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == 0 && !flag)
				continue;
			flag = true;
			String digit = a.get(i) + "";
			sb.append(digit);
		}
		if (sb.length() == 0)
			sb.append(0 + "");
		int res = Integer.valueOf(sb.toString()) + 1;
		String str = int2string(res);
		for (int i = 0; i < str.length(); i++)
			list.add(Integer.valueOf(str.substring(i, i + 1)));
		return list;
	}

	String int2string(int val) {
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		while (val > 0) {
			int tmp = val % 10;
			val /= 10;
			stack.push(tmp);
		}
		while (!stack.isEmpty()) {
			int val1 = stack.pop();
			sb.append(val1 + "");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Sprial sp = new Sprial();
		ArrayList<Integer> al = new ArrayList<>();
		al.add(0);
		System.out.println(sp.plusOne(al));
	}
}
