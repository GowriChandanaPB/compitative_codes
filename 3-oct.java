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