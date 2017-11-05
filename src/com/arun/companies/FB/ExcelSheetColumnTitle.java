package com.arun.companies.FB;

import java.util.LinkedList;
import java.util.Queue;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        ExcelSheetColumnTitle sol = new ExcelSheetColumnTitle();

        assert sol.convertToTitle(1).equalsIgnoreCase("A");
        assert sol.convertToTitle(2).equalsIgnoreCase("B");
        assert sol.convertToTitle(3).equalsIgnoreCase("C");
        assert sol.convertToTitle(26).equalsIgnoreCase("Z");
        assert sol.convertToTitle(27).equalsIgnoreCase("AA");
        assert sol.convertToTitle(28).equalsIgnoreCase("AB");
    }

    public String convertToTitle(int n) {
        StringBuilder temp = new StringBuilder();

        while (n != 0) {
            int r = n % 26;
            n = n / 26;
            if (r == 0) {
                temp.append((char)(90));
                n--;
            }else{
                temp.append((char)(64+r));
            }
        }
        String ret = temp.reverse().toString();
        System.out.println(ret);
        return ret;
    }
}
