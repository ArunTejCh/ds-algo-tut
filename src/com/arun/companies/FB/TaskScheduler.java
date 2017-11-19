package com.arun.companies.FB;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        TaskScheduler inst = new TaskScheduler();

        assert inst.leastInterval(new char[]{'A', 'A', 'A'}, 0) == 3;
        assert inst.leastInterval(new char[]{'A', 'A', 'A'}, 2) == 7;
        assert inst.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2) == 8;
        assert inst.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3) == 10;
        assert inst.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'C', 'C'}, 1) == 7;
        assert inst.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2) == 16;
    }

    public int leastIntervalPQ(char[] tasks, int n) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : tasks) {
            Integer val = charMap.get(c);
            if (val == null) {
                val = 0;
            }
            charMap.put(c, ++val);
        }

        int totalTime = 0;
        int cycleLength = n + 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        pq.addAll(charMap.values());

        while (!pq.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int workTime = 0;
            for (int i = 0; i < cycleLength; i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.poll());
                    workTime++;
                }
            }

            for (int t : temp) {
                if(--t > 0){
                    pq.offer(t);
                }
            }
            totalTime+= !pq.isEmpty() ? cycleLength : workTime;

        }
        return totalTime;
    }

    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];

        for(char c : tasks){
            count[c - 'A']++;
        }

        Arrays.sort(count);

        int i = 25;

        while(i >= 0 && count[i] == count[25]) i--;

        return Math.max(tasks.length, (count[25] - 1) * (n + 1) + 25 - i);
    }


}
