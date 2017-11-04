package com.arun.companies.FB;

import java.util.HashMap;

public class RomanToInt {

    public static void main(String[] args) {
        RomanToInt temp = new RomanToInt();
        System.out.println("Starting");
        int ret1 = temp.romanToInt("XIII");
        assert ret1 == 13;
        assert temp.romanToInt("MCM") == 1900;
        assert temp.romanToInt("LIV") == 54;
        assert temp.romanToInt("MXC") == 1090;
        assert temp.romanToInt("XIV") == 14;
        assert temp.romanToInt("MMMM") == 4000;
    }

    public int romanToInt(String s) {
        if(s.length() == 0)
            return -1;

        HashMap<String, Integer> rtoi = new HashMap<String, Integer>();
        rtoi.put("I", 1);
        rtoi.put("V", 5);
        rtoi.put("X", 10);
        rtoi.put("L", 50);
        rtoi.put("C", 100);
        rtoi.put("D", 500);
        rtoi.put("M", 1000);

        int ret = 0;
        int carry = 0;
        for(int i = 0; i < s.length(); i++){
            //System.out.println(s.charAt(i)+": "+ret);
            int val = rtoi.get(s.charAt(i)+"");
            if(val > carry && carry!=0){
                ret = ret + val - carry;
                carry = 0;
            }else{
                ret = ret + carry;
                carry = val;
            }
        }

        ret = ret + carry;
        System.out.println(s+" :"+ret);
        return ret;
    }
}
