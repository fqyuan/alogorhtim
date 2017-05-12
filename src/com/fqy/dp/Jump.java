package com.fqy.dp;

import java.util.ArrayList;

public class Jump {
	public int canJump(ArrayList<Integer> a) {
		int maxReach = 0;
		for (int i = 0; i < a.size(); i++) {
			if (i > maxReach)
				return 0;
			maxReach = Math.max(i + a.get(i), maxReach);
		}
		return 1;
	}
}
