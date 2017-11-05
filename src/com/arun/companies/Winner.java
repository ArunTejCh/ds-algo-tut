package com.arun.companies;

public class Winner {

    public static void main(String[] args) {

        assert winner(new int[]{1,2,3}, new int[]{2,1,3}, "Even").equalsIgnoreCase("Maria");
        assert winner(new int[]{1,2,3}, new int[]{2,1,3}, "Odd").equalsIgnoreCase("Andrea");

    }

    static String winner(int[] andrea, int[] maria, String s) {
        int andreaCount = 0;
        int mariaCount = 0;

        int start = 0;
        if(s.equalsIgnoreCase("Odd")){
            start = 1;
        }

        for(int i = start; i < andrea.length ; i = i+2){
            andreaCount = andreaCount + andrea[i] - maria[i];
            mariaCount = mariaCount + maria[i] - andrea[i];
        }


        if(andreaCount == mariaCount)
            return "Tie";
        else if(andreaCount > mariaCount)
            return "Andrea";
        else
            return "Maria";
    }
}
