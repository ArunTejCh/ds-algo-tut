package com.arun.companies.FB;

public class CountandSay {
    public static void main(String[] args) {

        CountandSay solution = new CountandSay();

        assert solution.countAndSay(1).equalsIgnoreCase("1");
        assert solution.countAndSay(2).equalsIgnoreCase("11");
        assert solution.countAndSay(3).equalsIgnoreCase("21");
        assert solution.countAndSay(4).equalsIgnoreCase("1211");
        assert solution.countAndSay(5).equalsIgnoreCase("111221");
        assert solution.countAndSay(6).equalsIgnoreCase("312211");
    }

    public String countAndSay(int n) {

        String cur = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            char curChar = cur.charAt(0);
            int counter = 1;
            for(int j = 1; j < cur.length(); j++){
                if(cur.charAt(j) == curChar){
                    counter++;
                }else{
                    temp.append( counter+""+(char)(curChar));
                    curChar = cur.charAt(j);
                    counter = 1;
                }
            }
            temp.append(counter+""+(char)(curChar));
            cur = temp.toString();
        }

        System.out.println(cur);
        return cur;
    }
}
