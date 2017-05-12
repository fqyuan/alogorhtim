package com.fqyuan.math;

public class GetBin {
	public static String findDigitsInBinary(int A) {

		String binary = "";

		if (A == 0)
			return "0";

		while (A != 0) {
			int dig = A % 2;
			// The sequence is important
			binary = (dig == 1 ? "1" : "0") + binary;
			A /= 2;
		}

		return binary;

	}

	public static String myMethod(int num) {
		String res = "";
		if (num == 0)
			res = "0";
		while (num > 0) {
			res += Integer.toString(num % 2);
			num /= 2;
		}
		return new StringBuilder(res).reverse().toString();
	}

	public static void main(String[] args) {
		String res = myMethod(11);
		System.out.println(res);
	}

}
