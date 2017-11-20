package com.arun.companies.FB;

import java.util.Arrays;

public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        int[] begin = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i = 0; i< intervals.length; i++){
            begin[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(begin);
        Arrays.sort(end);

        for(int i = 1; i < begin.length; i++){
            if(begin[i] < end[i-1])
                return false;
        }

        return true;
    }
}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
 }
