package com.fqy.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		tm.put(1, 1);
		tm.put(3, 4);
		tm.put(5, 8);
		tm.put(2, 19);
		System.out.println(tm.firstKey());
		System.out.println(tm.lastKey());
		System.out.println(tm.firstEntry().getKey());
		System.out.println(tm.ceilingEntry(4).getKey());
	}

	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		// int[] arr = A.stream().mapToInt(i -> i).toArray();
		ArrayList<Integer> arr = A;
		int k = B;
		ArrayList<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		if (k > arr.size()) {
			return result;
		}

		int index = 0;
		for (Integer integer : arr) {
			if (map.containsKey(integer)) {
				map.put(integer, map.get(integer) + 1);
			} else {
				map.put(integer, 1);
			}

			if (index >= k - 1) {
				result.add(map.size());
				if (map.get(arr.get(index - (k - 1))) > 1) {
					map.put(arr.get(index - (k - 1)), map.get(arr.get(index - (k - 1))) - 1);
				} else {
					map.remove(arr.get(index - (k - 1)));
				}
			}
			index++;
		}
		return result;
	}

}
// Why is the tree data structure important?
/*
 * For important search, insert, remove, Search: O(n) Insert: O(1)
 */
