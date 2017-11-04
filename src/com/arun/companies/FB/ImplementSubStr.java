package com.arun.companies.FB;

public class ImplementSubStr {
    public static void main(String[] args) {
        ImplementSubStr sol = new ImplementSubStr();

        String t1 = "";
        String t2 = "arunarunarun";
        String t3 = "This is a dummy str";
        String t4 = "nuraruxtaruk aruwnfwi arun";
        String t5 = "aaa";

        assert sol.strStr(t1, "arun") == -1;
        assert sol.strStr(t2, "arun") == 0;
        assert sol.strStr(t3, "arun") == -1;
        assert sol.strStr(t4, "arun") == 22;
        assert sol.strStr(t5, "aaaa") == -1;
        assert sol.strStr("mississippi", "issip") == 4;

    }

    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }

        char[] needles = needle.toCharArray();
        char[] hay = haystack.toCharArray();

        for(int i = 0; i < hay.length; i++){
            if(needles[0] == hay[i]){
                boolean found = true;
                for(int j = 1; j < needles.length; j++){
                    if(i + j > hay.length - 1){
                        return -1;
                    }
                    if(needles[j] != hay[i+j]){
                        found = false;
                        break;
                    }
                }
                if(found){
                    System.out.println("Str found at :"+i);
                    return i;
                }
            }
        }

        return -1;
    }
}
