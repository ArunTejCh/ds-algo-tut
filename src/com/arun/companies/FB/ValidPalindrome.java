package com.arun.companies.FB;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();
        assert sol.isPalindrome("A man, a plan, a canal: Panama");
    }

    public boolean isPalindrome(String s) {
        if(s.length() == 0 || s.length() ==1){
            return true;
        }

        s = s.toLowerCase();
        s = s.replaceAll("[^A-Za-z0-9]", "");

        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length() -1 - i))
                return false;
        }

        return true;
    }
}
