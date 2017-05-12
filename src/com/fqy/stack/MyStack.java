package com.fqy.stack;

import java.util.Stack;

public class MyStack {
	Stack<Integer> s;
	Integer minEle;

	// Constructor
	public MyStack() {
		s = new Stack<Integer>();
	}

	public void push(int x) {
		if (s.isEmpty()) {
			minEle = x;
			s.push(x);
			return;
		}
		// If new number if less than original minEle
		if (x < minEle) {
			s.push(2 * x - minEle);
			minEle = x;
		} else
			s.push(x);

	}

	public void pop() {
		if (s.isEmpty())
			return;
		Integer t = s.pop();
		// Minimum will change as the minimum element of the stack is removed
		if (t < minEle)
			minEle = 2 * minEle - t;
	}

	public int top() {
		if (s.isEmpty())
			return -1;
		Integer t = s.peek();
		// If t<minEle means minEle stores values of t
		if (t < minEle)
			return minEle;
		else
			return t;
	}

	public int getMin() {
		if (s.isEmpty())
			return -1;
		else
			return minEle;
	}

}
