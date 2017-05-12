package com.fqy.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaxPoints {
	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		if (a == null || b == null || a.size() == 0 || b.size() == 0)
			return 0;
		HashMap<Double, Integer> result = new HashMap<>();
		int max = 0;
		for (int i = 0; i < a.size(); i++) {
			int duplicate = 0;
			int vertical = 0;
			for (int j = i + 1; j < a.size(); j++) {
				// Handle duplicates and vertical
				if (a.get(i) == a.get(j)) {
					if (b.get(i) == b.get(j))
						duplicate++;
					else
						vertical++;
				} else {
					double slope = b.get(j) == b.get(i) ? 0.0 : (1.0 * (b.get(j) - b.get(i)) / (a.get(j) - a.get(i)));
					if (result.get(slope) != null)
						result.put(slope, result.get(slope) + 1);
					else
						result.put(slope, 1);
				}
			}

			for (Integer count : result.values()) {
				if (count + duplicate + 1 > max)
					max = count + duplicate + 1;
			}
			max = Math.max(vertical + duplicate, max);
			result.clear();
		}
		return max;
	}

	public int maxPoints1(ArrayList<Integer> A, ArrayList<Integer> B) {
		HashMap<Double, Integer> hashMap = new HashMap<>();
		if (A == null || B == null)
			return -1;
		if (A.size() == 0)
			return 0;
		int n = A.size();
		int x1, y1, x2, y2;
		int val;
		int max = 0;
		for (int i = 0; i < n; i++) {
			x1 = A.get(i);
			y1 = B.get(i);
			hashMap.clear();
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				x2 = A.get(j);
				y2 = B.get(j);
				double slope = y2 - y1;
				int den = x2 - x1;
				if (den == 0)
					slope = Double.POSITIVE_INFINITY;
				else
					slope = slope / den;
				val = 1;
				if (hashMap.containsKey(slope)) {
					val = hashMap.get(slope) + 1;
				}
				hashMap.put(slope, val);
			}
			for (Map.Entry<Double, Integer> entry : hashMap.entrySet()) {
				val = entry.getValue();
				max = Math.max(max, val);
			}
		}
		return max + 1;
	}
}
