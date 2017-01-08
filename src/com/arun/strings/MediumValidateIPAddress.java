package com.arun.strings;

public class MediumValidateIPAddress {

	public static void main(String[] args) {
		MediumValidateIPAddress  inst = new MediumValidateIPAddress();
		
		String arg1 = "172.16.254.1";
		String arg2 = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
		String arg3 = "256.256.256.256";
		String arg4 = "";
		String arg5 = null;
		String arg6 = "weoughweog.weghw.goweijg.gweoigj";
		String arg7 = "wfwe:wegfw:wegweg:wgweg:ewgr";
		
		assert inst.validIPAddress(arg1).equalsIgnoreCase("IPv4");
		assert inst.validIPAddress(arg2).equalsIgnoreCase("IPv6");
		assert inst.validIPAddress(arg3).equalsIgnoreCase("Neither");
		assert inst.validIPAddress(arg4).equalsIgnoreCase("Neither");
		assert inst.validIPAddress(arg5).equalsIgnoreCase("Neither");
		assert inst.validIPAddress(arg6).equalsIgnoreCase("Neither");
		assert inst.validIPAddress(arg7).equalsIgnoreCase("Neither");
		
		
	}

    public String validIPAddress(String IP) {
        
    	if(IP == null || IP.equalsIgnoreCase(""))
        	return "Neither";
        
        String[] v4 = IP.split("\\.", -1);
        String[] v6 = IP.split(":", -1);
        
        if(v4.length != 4 && v6.length != 8)
        	return "Neither";
    	
    	if(v4.length == 4){
    		for(String s : v4){
    			if((s.startsWith("0") && s.length() > 1) || s.startsWith("-"))
    				return "Neither";
    			boolean isNum = true;
    			int no = 0;
    			
    			try{
    				no = Integer.parseInt(s);
    			}catch(Exception e){
    				isNum = false;
    			}
    			if(!isNum || no < 0 || no > 255){
    				return "Neither";
    			}
    		}
    		
    		return "IPv4";
    	}
        
    	if(v6.length == 8){
    		for(String s : v6){
    			if(s.length() > 4 || s.startsWith("-")){
    				return "Neither";
    			}
    			boolean isNum = true;
    			long no = 0;
    			
    			try{
    				no = Long.parseLong(s,16);
    			}catch(Exception e){
    				isNum = false;
    			}
    			if(!isNum || no < 0){
    				return "Neither";
    			}
    		}
    		return "IPv6";
    	}
    	return "Neither";
    }
}
