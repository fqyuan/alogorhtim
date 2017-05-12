package com.fqy.interview;

public class Reuse {
	public static void main(String[] args) {
		System.out.println(new Reuse().compareBinToHex("110", "6"));
	}

	public boolean compareBinToHex(String binary, String hex) {
		int b = convertToBase(binary, 2);
		int h = convertToBase(hex, 16);
		if (b < 0 || h < 0)
			return false;
		else
			return b == h;
	}

	public int digitToValue(char c) {
		if (c >= '0' && c <= '9')
			return c - '0';
		else if (c >= 'a' && c <= 'f')
			return 10 + c - 'a';
		else if (c >= 'A' && c <= 'F')
			return 10 + c - 'A';
		else
			return -1;
	}

	public int convertToBase(String num, int base) {
		if (base < 2 || (base > 10 && base != 16))
			return -1;
		int result = 0;
		int len = num.length();
		for (int i = 0; i < len; i++) {
			int digit = digitToValue(num.charAt(i));
			if (digit >= base)
				return -1;
			// Notice that: the sequence is diverse
			result += digit * Math.pow(base, len - 1 - i);
		}
		return result;
	}

}
