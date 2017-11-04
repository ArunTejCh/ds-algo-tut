package com.arun.companies.FB;

public class HammingDistance {

    public static void main(String[] args) {
        HammingDistance temp = new HammingDistance();
        System.out.println(temp.deciToBinary(4));
        assert temp.hammingDistance(1, 4) == 2;
    }

    public int hammingDistance(int x, int y) {

        String binX = this.deciToBinary(x);
        String binY = this.deciToBinary(y);

        int diff = 0;
        if(x > y){
             diff = binX.length() - binY.length();
             for(int i=0;i< diff;i++){
                 binY = "0" + binY;
             }
        }else{
            diff = binY.length() - binX.length();
            for(int i=0;i< diff;i++){
                binX = "0" + binX;
            }
        }
        //System.out.println("X: "+binX);
        //System.out.println("Y: "+binY);
        int hammDist = 0;

        for(int i = 0; i < binY.length(); i++){
            //System.out.println(binX.charAt(i)+":"+binY.charAt(i));
            if(binX.charAt(i) != binY.charAt(i)) {
                hammDist++;
            }
        }
        //System.out.println(hammDist);
        return hammDist;
    }

    public String deciToBinary(int a){

        StringBuilder ret = new StringBuilder();

        while(a != 0){
            int remainder = a % 2;
            a = a/2;
            ret.insert(0,remainder);
        }

        return ret.toString();
    }
}
