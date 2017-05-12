package com.fqy.dp;

public class Stairs {
	/*
	 * For the climbing stairs issue, we can deduce it to the last two choice.
	 * 1. Go up from the last but one. 2. Go up from the last but two. No
	 * overlap is here for the solution, from the result we can see that they
	 * are of different solutions.
	 */
	public int climbStairs(int n) {
		int ways[] = new int[n + 1];
		ways[0] = 0;
		ways[1] = 1;
		ways[2] = 2;
		for (int i = 3; i <= n; i++) {
			ways[i] = ways[i - 1] + ways[i - 2];
		}
		return ways[n];
	}

	public int fib(int n) {
		int res[] = new int[n + 1];
		res[0] = 0;
		res[1] = 1;
		res[2] = 1;
		for (int i = 3; i <= n; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}
		return res[n];
	}

	/*
	 * dp[i] = dp[i-1] + dp[i-2]; Which means that current value can be deferred
	 * from the previous two.
	 */
	public int numDecoding(String str) {
		int[] dp = new int[str.length() + 1];
		dp[0] = 0;
		dp[1] = dp[1] != '0' ? 1 : 0;
		for (int i = 2; i <= str.length(); i++) {
			// It should be like this, with some limitations here.
			// dp[i] = dp[i-1]+dp[i-2];
			int first = Integer.valueOf(str.substring(i - 1, i));
			int second = Integer.valueOf(str.substring(i - 2, i));
			if (first >= 1 && first <= 9)
				dp[i] += dp[i - 1];
			if (second >= 10 && second <= 26)
				dp[i] += dp[i - 2];
		}
		return dp[str.length()];
	}
}
