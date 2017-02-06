package com.arun.dp;

public class EasyClimbStairs {

	public static void main(String[] args) {
		EasyClimbStairs inst = new EasyClimbStairs();

		assert inst.climbStairs(0) == 0;
		assert inst.climbStairs(1) == 1;
		assert inst.climbStairs(3) == 3;

	}

	public int climbStairs(int n) {
		if (n == 0 || n == 1)
			return n;

		int[] subs = new int[n+1];
		return recurse(n, subs);
	}

	int recurse(int n, int[] subs) {
		if (n == 0)
			return 1;

		int one = 0, two = 0;

		if (subs[n - 1] == 0) {
			one = recurse(n - 1, subs);
		} else {
			one = subs[n - 1];
		}

		if (n - 2 >= 0) {
			if (subs[n - 2] == 0) {
				two = recurse(n - 2, subs);
			} else {
				two = subs[n - 2];
			}
		}
		
		subs[n] = one + two;
		
		return subs[n];
	}
}
