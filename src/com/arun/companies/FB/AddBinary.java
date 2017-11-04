package com.arun.companies.FB;

public class AddBinary {
    public static void main(String[] args) {
        AddBinary sol = new AddBinary();

        assert sol.addBinary("11", "1").equalsIgnoreCase("100");
        assert sol.addBinary("1111", "1111").equalsIgnoreCase("11110");

    }

    public String addBinary(String a, String b) {
        int diff = 0;
        if(a.length() > b.length()){
            diff = a.length() - b.length();
            for(int i = 0; i < diff; i++){
                b = "0" + b;
            }
        }else{
            diff = b.length() - a.length();
            for(int i = 0; i < diff; i++){
                a = "0" + a;
            }
        }
        //System.out.println("a: "+ a+" b: "+b);
        StringBuilder ret = new StringBuilder();
        int carry = 0;
        for(int i = 0; i < a.length(); i++){
            int sum = carry + a.charAt(a.length() -1 -i) - 48 + b.charAt(b.length() -1 -i) - 48;
            //System.out.println("I: "+i+" sum: "+sum);
            switch (sum){
                case 3:
                    carry = 1;
                    ret.insert(0, 1);
                    break;
                case 2:
                    carry = 1;
                    ret.insert(0, 0);
                    break;
                case 1:
                    carry = 0;
                    ret.insert(0, 1);
                    break;
                case 0:
                    carry=0;
                    ret.insert(0,0);
                    break;
            }
        }
        if(carry == 1)
            ret.insert(0, 1);
        //System.out.println(ret.toString());
        return ret.toString();
    }


}
