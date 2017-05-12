package com.fqy.string;

public class LongestPalStr {

	public static void main(String[] args) {
		// forgeeksskeegfor
		System.out.println(new LongestPalStr().longestPalSub("abb"));
	}

	public String longPalStr(String str) {
		int len = 0;
		int maxLen = 0;
		int bestBegin = 0;
		int bestEnd = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j <= str.length(); j++) {
				if (isPal(str.substring(i, j))) {
					len = j - i;
					if (maxLen < len) {
						maxLen = len;
						bestBegin = i;
						bestEnd = j;
					}
				}
			}
		}

		return str.substring(bestBegin, bestEnd);
	}

	public boolean isPal(String str) {
		boolean flag = true;
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	// Dynamic Programming Method:
	public String longestPalSub(String str) {
		int len = str.length();
		int start = 0;
		int maxLenth = 1;

		/*
		 * table[i][j] will be false if substring str[i..j] is not palindrome.
		 */
		boolean[][] table = new boolean[len][len];
		// All substrings of length 1 are palindrome
		for (int i = 0; i < len; i++)
			table[i][i] = true;
		// Check for sub-string of length 2
		for (int i = 0; i < len - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxLenth = 2;
			}
		}
		// Check for lengths greater than 2. K is length of substring
		for (int k = 3; k <= len; k++) {
			// Fix the starting index
			for (int i = 0; i < len - k + 1; ++i) {
				// Get the ending index of substring from starting index i and
				// length k
				int j = i + k - 1;
				// Check for sub-string from ith index to jth index if str[i+1]
				// to str[j--1] is a palindrome
				if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					table[i][j] = true;
					if (k > maxLenth) {
						start = i;
						maxLenth = k;
					}
				}
			}
		}
		return str.substring(start, start + maxLenth);

	}
}
