package com.fqy.string;

import java.util.ArrayList;

public class CommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<>();
		al.add("geeksforgeeks");
		al.add("geeks");
		al.add("geek");
		al.add("geezer");
		System.out.println(new CommonPrefix().longestCommonPrefix(al));
	}

	public String longestCommonPrefix(ArrayList<String> al) {
		String result = al.get(0);
		for (int i = 1; i < al.size(); i++) {
			result = commmonPrefixUtil(result, al.get(i));
		}
		return result;
	}

	// A Utility function to find the common prefix between Strings: str1 and
	// str2
	public String commmonPrefixUtil(String str1, String str2) {
		StringBuilder result = new StringBuilder();
		int len1 = str1.length();
		int len2 = str2.length();
		for (int i = 0, j = 0; i < len1 && j < len2; i++, j++) {
			if (str1.charAt(i) != str2.charAt(j))
				break;
			result.append(str1.charAt(i));
		}
		return result.toString();
	}
}
