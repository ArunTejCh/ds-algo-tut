package com.arun.math;

import java.util.HashSet;
import java.util.Set;

public class MediumBulbSwitcher {

	public static void main(String[] args) {
		MediumBulbSwitcher inst = new MediumBulbSwitcher();
		
		int arg1 = 1;
		int arg2 = 2;
		int arg3 = 3;
		int arg4 = 4;
		int arg5 = 5;
		
		assert inst.bulbSwitch(arg1) == 1;
		assert inst.bulbSwitch(arg2) == 1;
		assert inst.bulbSwitch(arg3) == 1;
		assert inst.bulbSwitch(arg4) == 2;
		assert inst.bulbSwitch(arg5) == 2;
		
		
	}

    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
     }
	
}
