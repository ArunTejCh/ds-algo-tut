package com.arun.companies.FB;

public class SqrtX {
    public static void main(String[] args) {
        SqrtX sol = new SqrtX();

        assert sol.mySqrt(0) == 0;
        assert sol.mySqrt(5) == 2;
        assert sol.mySqrt(9) == 3;
        assert sol.mySqrt(15) == 3;
        sol.mySqrt(2147395599);
    }

    public int mySqrt(int x) {
        if(x == 0 || x == 1)
            return x;

        long upper = x;
        long lower = 0;
        while(upper != lower){
            long mid = (upper + lower)/2;
            long val = mid * mid;

            if(val == x){
                return (int) mid;
            }else if(val < x){
                if(upper == lower + 1){
                    upper = mid;
                }else{
                    lower = mid;
                }

            }else{
                if(upper == lower + 1){
                    lower = mid;
                }else{
                    upper = mid;
                }
            }
        }
        return (int)lower;
    }

}
