package com.arun.companies;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ApacheLogSuccesRates {
    public static void main(String[] args) {

        //Scanner input = new Scanner(System.in);
        ArrayList<String> details = new ArrayList<String>();
        //while (input.hasNext()) {
        //  details.add(input.nextLine());
        //System.out.println(input.nextLine());
        //}
        details.add("64.242.88.10 - - [07/Mar/2004:16:05:49 -0800] \"GET /1.1/friendships/list.json?user_id=123 HTTP/1.1\" 401 12846\n");
        ArrayList<String> output = aggregate(details);
        for (String det : output) {
            System.out.println(det);
        }

        //System.out.println(new Date().toString());

    }

    public static ArrayList<String> aggregate(ArrayList<String> details) {


        TreeMap<Date, TreeMap<String, Integer>> data = new TreeMap<Date, TreeMap<String, Integer>>();

        for (int i = 0; i < details.size(); i++) {
            try {
                String curLog = details.get(i);
                String date = curLog.substring(curLog.indexOf('[') + 1, curLog.indexOf(']'));
                System.out.println("Date: " + date);
                SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy:HH:mm", Locale.US);
                String api = curLog.substring(curLog.indexOf("GET ") + 4, curLog.indexOf(".json") + 5);
                System.out.println("API: "+api);
                Date d = df.parse(date);
                System.out.println("arun: "+d.toString());
                SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                System.out.println("parsed Date: "+ df2.format(d).toString());

                String errorCode = curLog.substring(curLog.indexOf('[') + 1, curLog.indexOf(']'));
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
        return null;

    }


}
