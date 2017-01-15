package com.arun.math;

public class EasyReverseInteger {

	public static void main(String[] args) {
		EasyReverseInteger inst = new EasyReverseInteger();

		int arg1 = 0;
		int arg2 = -0;
		int arg3 = 123;
		int arg4 = -123;
		int arg5 = 4310;

		assert inst.reverse(arg1) == 0;
		assert inst.reverse(arg2) == -0;
		assert inst.reverse(arg3) == 321;
		assert inst.reverse(arg4) == -321;
		assert inst.reverse(arg5) == 134;

	}

	public int reverse(int x) {
		StringBuilder rev = new StringBuilder();
		String num = x + "";
		if (num.startsWith("-")) {
			num = num.substring(1);
			rev.append("-");
		}

		for (int i = num.length() - 1; i >= 0; i--) {
			rev.append(num.charAt(i));
		}

		long ret = Long.parseLong(rev.toString());
		if(ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE){
			return 0;
		}else{
			return (int)ret;
		}
		
	}

}
