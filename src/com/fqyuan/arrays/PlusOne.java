package com.fqyuan.arrays;

import java.util.ArrayList;

public class PlusOne {
	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		ArrayList<Integer> result = new ArrayList<>();
		// 1.Remove duplicate zero
		/*
		 * Q:Why is the following operation not working? A:After removal, the
		 * ArrayList has changed then.
		 */
		for (int i = 0; i < a.size() - 1; i++) {
			if (a.get(i) == 0)
				a.remove(i);
			else
				break;
		}
		// 2.Deal with carry
		int carry = 0;
		for (int i = a.size() - 1; i >= 0; i--) {
			int sum = a.get(i) + carry;
			a.set(i, sum % 10);
			carry = sum / 10;
		}
		// 3.Copy the altered array into result array

		if (carry == 1) {
			result.add(1);
			result.addAll(a);
		} else {
			result.addAll(a);
		}
		return result;
	}

	public ArrayList<Integer> plusOne1(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<>();
		// First, deal with the plus one issue considering carry
		int carry = 1;
		for (int i = A.size() - 1; i >= 0; i--) {
			int sum = A.get(i) + carry;
			A.set(i, sum % 10);
			carry = sum / 10;
		}
		// Second, put the element to the answer list
		if (carry == 1)
			result.add(1);
		else {
			for (Integer ele : A) {
				if (result.size() == 0 && ele == 0)
					continue;
				result.add(ele);
			}
		}
		return result;
	}
}
