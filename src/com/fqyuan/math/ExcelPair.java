package com.fqyuan.math;

public class ExcelPair {
	public static int titleToNumber(String a) {
		int res = 0;
		for (int i = a.length() - 1; i >= 0; i--) {
			res += (a.charAt(i) - 'A' + 1) * Math.pow(26, a.length() - 1 - i);
		}
		return res;
	}

	public static int reverse(int a) {
		int res = 0;
		int sign = 1;
		if (a < 0) {
			a = -a;
			sign = -1;
		}
		while (a > 0) {
			if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && a % 10 > Integer.MAX_VALUE % 10))
				return 0;
			res = res * 10 + a % 10;
			a /= 10;
		}
		res *= sign;
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-214748364));
	}

}
