package com.fqy.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BitOpe {
	public int findMinXor(ArrayList<Integer> al) {
		int res;
		// Collections and Arrays are different!
		Arrays.sort(al.toArray());
		res = al.get(0) ^ al.get(1);
		for (int i = 1; i < al.size() - 1; i++) {
			int temp = al.get(i) ^ al.get(i + 1);
			res = Math.min(temp, res);
		}
		return res;
	}

	public int cntBits(ArrayList<Integer> A) {
		int res = 0;
		int len = A.size();
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < len; j++) {
				if ((A.get(j) & (1 << i)) == 0 ? false : true)
					count++;
				res += (len - count) * count * 2;
			}
		}
		return res;
	}

	public int singleNumber(final List<Integer> al) {
		int res = 0;
		int len = al.size();
		int x, sum = 0;
		for (int i = 0; i < 32; i++) {
			sum = 0;
			x = (1 << i);
			for (int j = 0; j < len; j++) {
				if ((al.get(j) & x) == 0 ? false : true) {
					sum++;
				}
			}
			if (sum % 3 != 0)
				res |= x;
		}
		return res;
	}

	public int removeDuplicates(ArrayList<Integer> al) {
		if (al.size() == 0)
			return 0;
		int j = 0;
		for (int i = 1; i < al.size(); i++) {
			// Don't forget the initValue() method when comparing!
			if (al.get(j).intValue() != al.get(i).intValue())
				al.set(++j, al.get(i));
		}
		return j + 1;
	}

	// Find 3 elements such that
	// max(abs(A[i]-B[j]),abs(B[j]-C[k]),abs(C[k]-A[i])) is minimized
	public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
		// Initialize min diff
		int diff = Integer.MAX_VALUE;
		// Initialize result
		int resI, resJ, resK;
		// Traverse arrays:
		int i = 0, j = 0, k = 0;
		while (i < a.size() && j < b.size() & k < c.size()) {
			// Find minumum and maximum of current three elements
			int minimum = Math.min(a.get(i), Math.min(b.get(j), c.get(k)));
			int maximum = Math.max(a.get(i), Math.max(b.get(j), c.get(k)));

			// Update result if current diff is less than the min diff so far
			if (maximum - minimum < diff) {
				resI = i;
				resJ = j;
				resK = k;
				diff = maximum - minimum;
			}
			// We can't get less than 0 as values are absolute
			if (diff == 0)
				break;
			// Increment index of array with smallest value
			if (a.get(i) == minimum)
				i++;
			else if (b.get(j) == minimum)
				j++;
			else
				k++;
		}
		return diff;
	}

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int kthsmallest(final List<Integer> a, int k) {
		int result = 0;
		Collections.sort(a);
		result = a.get(k - 1);
		return result;
	}

	public int kthSmall(final List<Integer> a, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for (Integer ele : a) {
			q.offer(ele);
			if (q.size() > k)
				q.poll();
		}
		return q.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(15);
		al.add(5);
		al.add(1);
		al.add(10);
		al.add(2);
		System.out.println(al);
		Collections.sort(al);
		System.out.println(al);
		System.out.println();
	}

}
