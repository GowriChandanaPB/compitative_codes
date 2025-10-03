// 1. Insert Interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<int[]> res = new ArrayList<>();

        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}


// 2. Merge Intervals

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int[] i : intervals) {
            int p = i[0];
            int q = i[1];
            int lastEnd = res.get(res.size() - 1)[1];

            if (p <= lastEnd) {
                res.get(res.size() - 1)[1] = Math.max(lastEnd, q);
            } else {
                res.add(new int[]{p, q});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}


// 3. Non-overlapping Intervals

 class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int p = intervals[i][0];
            int q = intervals[i][1];
            if (p < prevEnd) {
                res++;
            } else {
                prevEnd = q;
            }
        }
        return res;
    }
}


// 4. Meeting Rooms

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        for (int i = 1; i < intervals.size(); i++) {
            Interval i1 = intervals.get(i - 1);
            Interval i2 = intervals.get(i);

            if (i1.end > i2.start) {
                return false;
            }
        }

        return true;
    }
}


// 5. Meeting Rooms II

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] p = new int[n];
        int[] q = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = intervals.get(i).p;
            q[i] = intervals.get(i).q;
        }

        Arrays.sort(p);
        Arrays.sort(q);

        int res = 0, count = 0, s = 0, e = 0;
        while (s < n) {
            if (p[s] < q[e]) {
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
}