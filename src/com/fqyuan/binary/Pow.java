package com.fqyuan.binary;

public class Pow {
	public static void main(String[] args) {
		System.out.println(new Pow().pow(5, 5, 3));
	}

	public int pow(int x, int n, int d) {
		long base = x;
		long res = 1L;
		while (n > 0) {
			if (n % 2 == 1) {
				res = res * base % d;
				n--;
			} else {
				base = base * base % d;
				n /= 2;
			}
		}
		res = (res + d) % d;
		return (int) res;
	}
}
