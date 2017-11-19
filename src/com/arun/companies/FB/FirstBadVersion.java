package com.arun.companies.FB;

public class FirstBadVersion {
    public static void main(String[] args) {
        FirstBadVersion sol = new FirstBadVersion();


    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while(low!=high){
            int mid = (low + high)/2;
            boolean bad = this.isBadVersion(mid);
            if(!bad){
                if(low == (high -1)){
                    low = high;
                }else{
                    low = mid;
                }
            }else{
                if(mid == 1)
                    return 1;
                boolean pre = this.isBadVersion(mid - 1);
                if(!pre){
                    return mid;
                }else{
                    high = mid;
                }

            }

        }

        return low;
    }

    public boolean isBadVersion(int version){

        return false;
    }

}
