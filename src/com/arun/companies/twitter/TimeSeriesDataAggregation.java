import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner input = new Scanner(System.in);
        ArrayList<String> details = new ArrayList<String>();
        while (input.hasNext()) {
            details.add(input.nextLine());
            //System.out.println(input.nextLine());
        }

        ArrayList<String> output = aggregate(details);
        for(String det : output){
            System.out.println(det);
        }
    }

    public static ArrayList<String> aggregate(ArrayList<String> details){
        String testDateString = "02/04/2014";
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        TreeMap<Date,TreeMap<String,Integer>> data = new TreeMap<Date,TreeMap<String,Integer>>();


        try{
            Date start = df.parse(details.get(0).split(",")[0]);
            Date end = df.parse(details.get(0).split(",")[1]);
            for(int i = 2; i < details.size();i++){
                String[] lineData = details.get(i).split(",");
                Date time = df.parse(lineData[0]);
                if(time.compareTo(start) < 0 || time.compareTo(end) >= 0){
                    continue;
                }
                if(!data.containsKey(time)){
                    data.put(time, new TreeMap<String,Integer>());
                }
                TreeMap<String,Integer> data2 = data.get(time);
                if(!data2.containsKey(lineData[1])){
                    data2.put(lineData[1], 0);
                }
                data2.put(lineData[1], data2.get(lineData[1]) + Integer.parseInt(lineData[2].trim()));
                //System.out.println(new SimpleDateFormat("yyyy-MM").format(time));
            }
            //System.out.println(data.toString());
        } catch(Exception e){
            e.printStackTrace();
        }
        ArrayList<String> ret = new ArrayList<String>();
        Set<Date> keys = data.keySet();
        for(Date key: keys){
            TreeMap<String, Integer> hits = data.get(key);
            StringBuilder temp = new StringBuilder();
            temp.append(new SimpleDateFormat("yyyy-MM").format(key));
            Set<String> k2 = hits.keySet();
            for(String k : k2){
                temp.append(","+k+", "+hits.get(k));
            }

            ret.add(temp.toString());
        }
        Collections.reverse(ret);

        return ret;
    }

}