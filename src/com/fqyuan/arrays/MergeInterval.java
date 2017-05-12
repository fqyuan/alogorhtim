package com.fqyuan.arrays;

import java.util.LinkedList;
import java.util.List;

public class MergeInterval {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1)
			return intervals;
		// Sort by ascending starting point using an anonymous Cmparator
		/*
		 * Integer.compare(): val1-val2 sort: List.sort(), sort the list
		 * according to the order induced by the specified Comparator.
		 */
		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

		List<Interval> result = new LinkedList<Interval>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for (Interval interval : intervals) {
			if (interval.start <= end) // Overlapping intervals, move the end if
										// needed
				end = Math.max(end, interval.end);
			else { // Disjoint intervals, add the previous one and reset bounds
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		// Add the last interval
		result.add(new Interval(start, end));
		return result;
	}

	public static void main(String[] args) {
		MergeInterval m = new MergeInterval();
		LinkedList<Interval> list = new LinkedList<Interval>();
		Interval l1 = new Interval(1, 3);
		Interval l2 = new Interval(2, 6);
		Interval l3 = new Interval(8, 10);
		Interval l4 = new Interval(15, 18);
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		System.out.println(list);
		System.out.println(m.merge(list));
	}
}
