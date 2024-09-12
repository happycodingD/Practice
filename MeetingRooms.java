package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRooms {

    public static int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for(int i=0; i<intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0;
        int e = 0;
        int res = 0, count = 0;

        while(s < intervals.size()) {
            if (start[s] < end[e]) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 40));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));
        System.out.println(minMeetingRooms(intervals));
    }

}

