package com.danal;

/**
 * Print a random number for each string.  If the string is given more than once, it should print the same random number as before
 * 
 * YOU CAN USE ANY JAVA LIBRARY: math, collections, etc.
 */
public class StringToRandom {

    public static void main(String[] args) {
        System.out.println(functionToBuild("hello"));
        System.out.println(functionToBuild("blue"));
        System.out.println(functionToBuild("cat"));
        System.out.println(functionToBuild("baseball"));
        System.out.println(functionToBuild("hello"));
    }

    private static String functionToBuild(String input) {

        
        //ADD CODE HERE
        int randomHash = 0;

        StringBuilder random = new StringBuilder();

        for(int i = 0; i < input.length(); i++){

            random.append((char)(input.charAt(i)% 26 + 97));
        }

        return random.toString();
                
    }
}
