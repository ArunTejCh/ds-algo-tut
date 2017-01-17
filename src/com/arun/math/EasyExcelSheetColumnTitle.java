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
		assert inst.convertToTitle(arg5).equalsIgnoreCase("YZ");
		assert inst.convertToTitle(arg6).equalsIgnoreCase("AAA");
	}

	
    public String convertToTitle(int n) {
        StringBuilder conversion = new StringBuilder();
        
        while(n > 0){
        	int rem = n % 26;
        	int div = n/26;
        	if(rem == 0){
        		conversion.append((char)(64 + 26));
        		div--;
        	}else{
        		conversion.append((char)(64 + rem));
        	}
        	n = div;
        }
        
        String con = conversion.reverse().toString();
        
    	return con;
    }
}
