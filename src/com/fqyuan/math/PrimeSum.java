package com.fqyuan.math;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class PrimeSum {
	public static ArrayList<Integer> primeSum(int num) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 2; i < num; i++) {
			if (isPrime(i) && isPrime(num - i)) {
				al.add(i);
				al.add(num - i);
				break;
			}
		}
		return al;
	}

	public static ArrayList<List<Integer>> primePairs(int num) {
		ArrayList<List<Integer>> al = new ArrayList<>();
		// for (int i = 0; i < num; i++)
		// al.add(new ArrayList<>());
		int j = 0;
		for (int i = 2; i < num; i++) {
			if (isPrime(i) && isPrime(num - i)) {
				al.add(new ArrayList<>());
				al.get(j).add(i);
				al.get(j++).add(num - i);
			}
		}
		return al;
	}

	/*
	 * Naturally sorted by the key sets. A Red-Black tree based NavigableMap
	 * implementation. The map is sorted according to the natural ordering of
	 * its keys, or by a Comparator provided at map creation time, depending on
	 * which constructor is used.
	 */
	public static TreeMap<Integer, Integer> primePair(int num) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 2; i < num; i++) {
			if (isPrime(i) && isPrime(num - i)) {
				map.put(i, num - i);
			}
		}
		return map;
	}

	public static boolean isPrime(int num) {
		if (num < 2)
			return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(primePair(20));
	}

}
