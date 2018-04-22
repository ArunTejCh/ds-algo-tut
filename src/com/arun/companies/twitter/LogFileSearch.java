/*
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LogFileSearch {
    public Collection<String> search(Collection<String> logLines, LocalTime startDate, LocalTime endDate){
        Collection<String> ret = new ArrayList<String>();;
        ArrayList<String> lines = ((ArrayList<String>)logLines);
        boolean read = false;
        for(int i = 0; i < lines.size(); i++){
            if(lines.get(i).contains(startDate.toString())){
                read = true;
            }else if(lines.get(i).contains(endDate.toString())){
                read = false;
            }

            if(read)
                ret.add(lines.get(i));
        }


        return ret;
    }


    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        LocalTime startDate = LocalTime.parse(in.nextLine(), formatter);
        LocalTime endDate = LocalTime.parse(in.nextLine(), formatter);

        final int numberOfLogLines = Integer.parseInt(in.nextLine());
        Collection<String> logLines = new ArrayList<String>();
        for (int i = 0; i < numberOfLogLines; i++) {
            logLines.add(in.nextLine());
        }
        in.close();

        Collection<String> res = new LogSearcher().search(logLines, startDate, endDate);
        for (String logLine : res) {
            bw.write(logLine);
            bw.newLine();
        }

        bw.close();
    }
}*/
