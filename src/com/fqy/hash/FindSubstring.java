package com.fqy.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSubstring {
	// public List<Integer> findSubstring(String s, String[] words) {
	public List<Integer> findSubstring(String s, final List<String> words) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words == null || words.size() == 0) {
			return result;
		}

		// frequency of words
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String w : words) {
			if (map.containsKey(w)) {
				map.put(w, map.get(w) + 1);
			} else {
				map.put(w, 1);
			}
		}

		int len = words.get(0).length();

		for (int j = 0; j < len; j++) {
			HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
			int start = j;// start index of start
			int count = 0;// count totoal qualified words so far

			for (int i = j; i <= s.length() - len; i = i + len) {
				String sub = s.substring(i, i + len);
				if (map.containsKey(sub)) {
					// set frequency in current map
					if (currentMap.containsKey(sub)) {
						currentMap.put(sub, currentMap.get(sub) + 1);
					} else {
						currentMap.put(sub, 1);
					}

					count++;

					while (currentMap.get(sub) > map.get(sub)) {
						String left = s.substring(start, start + len);
						currentMap.put(left, currentMap.get(left) - 1);

						count--;
						start = start + len;
					}

					if (count == words.size()) {
						result.add(start); // add to result

						// shift right and reset currentMap, count & start point
						String left = s.substring(start, start + len);
						currentMap.put(left, currentMap.get(left) - 1);
						count--;
						start = start + len;
					}
				} else {
					currentMap.clear();
					start = i + len;
					count = 0;
				}
			}
		}

		return result;
	}

	// public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
	public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> num) {
		ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
		returnList.add(new ArrayList<Integer>());

		for (int i = 0; i < num.size(); i++) {
			Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
			for (List<Integer> l : returnList) {
				for (int j = 0; j < l.size() + 1; j++) {
					l.add(j, num.get(i));
					ArrayList<Integer> T = new ArrayList<Integer>(l);
					l.remove(j);
					currentSet.add(T);
				}
			}
			returnList = new ArrayList<ArrayList<Integer>>(currentSet);
		}

		return returnList;
	}
}
