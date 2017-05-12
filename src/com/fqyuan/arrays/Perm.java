package com.fqyuan.arrays;

import java.util.ArrayList;

public class Perm {
	public ArrayList<ArrayList<Integer>> getPerm(int arr[], int val) {
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			res = 0;
			for (int j = i; j < arr.length; j++) {
				res += arr[j];
				if (res >= val) {
					ArrayList al1 = new ArrayList();
					for (int k = i; k <= j; k++)
						al1.add(arr[k]);
					al.add(al1);
				}
			}
			if (res < val)
				break;
		}
		return al;
	}

	public ArrayList<ArrayList<Integer>> getPerm1(int arr[], int val) {
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		int res = 0;
		// cnt
		for (int cnt = 1; cnt < arr.length; cnt++) {
			for (int j = 0; j < arr.length; j++) {

			}
		}
		return al;
	}

	public ArrayList valArr(int arr[], int cnt, int val) {
		ArrayList al = new ArrayList<>();
		int res = 0;
		for (int i = 0; i < arr.length; i++) {

		}
		return al;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(new Perm().getPerm(arr, 10));
	}

}
