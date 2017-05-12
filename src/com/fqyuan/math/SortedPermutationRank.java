package com.fqyuan.math;

public class SortedPermutationRank {
	public static int findRank(String a) {
		int mod = 1000003;
		int res = 0;
		for (int i = 0; i < a.length(); i++) {
			res = (res + findSmallerDigitsRight(a, i) * fact(a.length() - i - 1)) % mod;
		}
		return res + 1;
	}

	static int fact(int n) {
		int res = 1;
		while (n > 1)
			res *= n--;
		return res;
	}

	static int findSmallerDigitsRight(String a, int cnt) {
		int res = 0;
		for (int i = cnt + 1; i < a.length(); i++) {
			if (a.charAt(i) < a.charAt(cnt))
				res++;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(findRank("ZCSFLVHXRYJQKWABGT"));
	}
}
