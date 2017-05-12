package com.fqy.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlideMax {
	public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
		ArrayList<Integer> result = new ArrayList<>();
		Deque<Integer> doubleQueue = new LinkedList<Integer>();
		// Calculate the first window max
		for (int i = 0; i < b; i++) {
			while (!doubleQueue.isEmpty() && a.get(i) > doubleQueue.peekLast())
				doubleQueue.removeLast();
			doubleQueue.push(a.get(i));
			// doubleQueue.addLast(a.get(i));
		}
		result.add(doubleQueue.peekLast());
		// Then try to move the window right and pop
		for (int i = b; i < a.size(); i++) {
			if (doubleQueue.size() == b) // if full
				doubleQueue.removeFirst();
			while (!doubleQueue.isEmpty() && a.get(i) > doubleQueue.peekLast())
				doubleQueue.removeLast();
			doubleQueue.addLast(a.get(i));
			result.add(doubleQueue.peekFirst());
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
