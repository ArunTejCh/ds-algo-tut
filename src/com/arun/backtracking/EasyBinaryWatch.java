package com.arun.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EasyBinaryWatch {

	public static void main(String[] args) {
		EasyBinaryWatch inst = new EasyBinaryWatch();
		
		List<String> ret = inst.readBinaryWatch(1);
		
		System.out.println(ret);
	}

	public List<String> readBinaryWatch(int num) {
		if (num == 0) {
			List<String> ret = new ArrayList<String>();
			ret.add("0:00");
			return ret;
		}

		int[] values = new int[10];

		values[0] = 1;
		values[4] = 1;

		for (int i = 1; i < 4; i++) {
			values[i] = values[i - 1] * 2;
		}

		for (int i = 5; i < 10; i++) {
			values[i] = values[i - 1] * 2;
		}

		HashSet<String> times = new HashSet<String>();

		int[] temp = new int[10];

		for (int i = 0; i < 10; i++) {
			temp[i] = 1;
			recurse(temp, times, values, num - 1);
			temp[i] = 0;
		}

		return new ArrayList<String>(times);
	}

	private void recurse(int[] temp, HashSet<String> times, int[] values, int num) {
		if (num == 0) {
			times.add(computeValue(temp, values));
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (temp[i] == 1)
				continue;

			temp[i] = 1;
			if (checkFeasibility(temp, values)) {
				recurse(temp, times, values, num - 1);
			}
			temp[i] = 0;
		}
	}

	private String computeValue(int[] temp, int[] values) {
		int hrs = 0;

		for (int i = 0; i < 4; i++) {
			if (temp[i] == 1)
				hrs = hrs + values[i];
		}

		int mins = 0;

		for (int i = 4; i < 10; i++) {
			if (temp[i] == 1)
				mins = mins + values[i];
		}
		
		String minutes = mins+"";
		if(minutes.length() == 1)
			minutes = "0"+minutes;
		return hrs+":"+minutes;
	}

	private boolean checkFeasibility(int[] temp, int[] values) {

		int hrs = 0;

		for (int i = 0; i < 4; i++) {
			if (temp[i] == 1)
				hrs = hrs + values[i];
		}

		if (hrs > 11)
			return false;

		int mins = 0;

		for (int i = 4; i < 10; i++) {
			if (temp[i] == 1)
				mins = mins + values[i];
		}

		if (mins > 59)
			return false;

		return true;
	}
}
