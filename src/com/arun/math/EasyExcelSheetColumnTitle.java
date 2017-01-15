package com.arun.math;

public class EasyExcelSheetColumnTitle {

	public static void main(String[] args) {
		EasyExcelSheetColumnTitle inst = new EasyExcelSheetColumnTitle();
		
		int arg1 = 1;
		int arg2 = 26;
		int arg3 = 52;
		int arg4 = 53;
		int arg5 = 676;
		int arg6 = 677;
		
		assert inst.convertToTitle(arg1).equalsIgnoreCase("A");
		assert inst.convertToTitle(arg2).equalsIgnoreCase("Z");
		assert inst.convertToTitle(arg3).equalsIgnoreCase("AZ");
		assert inst.convertToTitle(arg4).equalsIgnoreCase("BA");
		assert inst.convertToTitle(arg5).equalsIgnoreCase("ZZ");
		assert inst.convertToTitle(arg6).equalsIgnoreCase("AAA");
	}

	
    public String convertToTitle(int n) {
        int a = 'A';//65
        int z = 'Z';//90
        StringBuilder conversion = new StringBuilder();
        
        while(n > 0){
        	conversion.append(n % 26);
        	n = n/26;
        }
        
        String con = conversion.reverse().toString();
        
    	return null;
    }
}
