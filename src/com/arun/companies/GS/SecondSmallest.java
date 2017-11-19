package com.arun.companies.GS;

public class SecondSmallest {

    public static void main(String[] args) {
        SecondSmallest inst = new SecondSmallest();

        assert inst.getSecondSmallest(new int[]{}) == 0;
        assert inst.getSecondSmallest(new int[]{1}) == 0;
        assert inst.getSecondSmallest(new int[]{1,1,1}) == 1;
        assert inst.getSecondSmallest(new int[]{7,2,3,4,5,6}) == 3;
        assert inst.getSecondSmallest(new int[]{1,3,5,-6,-9}) == -6;
        assert inst.getSecondSmallest(new int[]{5,1,2,3,4,5}) == 2;


    }

    int getSecondSmallest(int[] input){

        if(input.length == 0 || input.length == 1){
            return 0;
        }

        int first = input[0];
        int second = input[1];
        if(second < first){
            int temp = first;
            first = second;
            second = temp;
        }


        for(int i = 2; i < input.length; i++){
            int cur = input[i];
            if(cur < first ){
                second = first;
                first = cur;
            }else if(cur < second && cur >= first){
                second = cur;
            }else{
                //do nothing
            }
        }

        return second;
    }
}
