package com.fqyuan.math;

import java.util.ArrayList;
import java.util.Arrays;

public class Hamming {
	public static int hammingDistance(ArrayList<Integer> list) {
		int size = list.size();
		int mod = 1000000007;
		int sum = 0;
		for (int i = 0; i < 31; i++) {
			int cntOne = 0, cntZero = 0;
			for (int j = 0; j < size; j++) {
				if ((list.get(j) & (1 << i)) == 0)
					cntZero++;
				else
					cntOne++;
			}
			sum += 2 * cntOne * cntZero;
			// if (sum >= mod)
			// sum -= mod;
		}
		return sum;
	}

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(2, 4, 6));
		System.out.println(hammingDistance(al));
	}
}
