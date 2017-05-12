package com.fqyuan.binary;

/*
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * If x is not a perfect square, return floor(sqrt(x))
 */
public class Sqrt {
	public int sqrt(int x) {
		int res = 0;
		int t = 1;
		while (t * t < x) {
			t *= 2;
			if (t * t > x)
				if (x - 1 < t * t && t * t > x + 1) {
					res = x;
					break;
				}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
