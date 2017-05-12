package com.fqy.stack;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseAlo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/",
	 * "+"] -> (4 + (13 / 5)) -> 6
	 */
	public int evalRPN(ArrayList<String> a) {
		int result = 0;
		String operators = "+-*/";
		Stack<String> stack = new Stack<String>();
		for (String str : a) {
			if (!operators.contains(str)) {
				stack.push(str);
			} else {
				int num1 = Integer.valueOf(stack.pop());
				int num2 = Integer.valueOf(stack.pop());
				int index = operators.indexOf(str);
				switch (index) {
				case 0:
					stack.push(String.valueOf(num2 + num1));
					break;
				case 1:
					stack.push(String.valueOf(num2 - num1));
					break;
				case 2:
					stack.push(String.valueOf(num2 * num1));
					break;
				case 3:
					stack.push(String.valueOf(num2 / num1));
					break;
				default:
					break;
				}
			}
		}
		result = Integer.valueOf(stack.pop());
		return result;
	}
}
