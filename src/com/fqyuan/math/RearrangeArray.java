package com.fqyuan.math;

import java.util.ArrayList;

public class RearrangeArray {
	void rearrange(int arr[], int n) {
		// First step: increase all values by :
		for (int i = 0; i < n; i++)
			arr[i] += (arr[arr[i]] % n) * n;
		// Second step: divide all values by n
		for (int i = 0; i < n; i++)
			arr[i] /= n;
	}

	public static void arrange(ArrayList<Integer> a) {
		for (int i = 0; i < a.size(); i++) {
			a.set(i, (a.get(a.get(i)) % a.size()) * a.size() + a.get(i));
		}
		for (Integer ele : a)
			ele /= a.size();
		for (int i = 0; i < a.size(); i++)
			a.set(i, a.get(i) / a.size());
	}

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(3);
		al.add(2);
		al.add(0);
		al.add(1);
		System.out.println(al);
		arrange(al);
		System.out.println(al);
	}

}
