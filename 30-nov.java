// 1. Maximum Profit in Job Scheduling

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] job = new int[n][3];
        for (int i = 0; i < n; i++) {
            job[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(job, (a, b)->a[1] - b[1]);
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (int[] j : job) {
            int cur = dp.floorEntry(j[0]).getValue() + j[2];
            if (cur > dp.lastEntry().getValue())
                dp.put(j[1], cur);
        }
        return dp.lastEntry().getValue();
    }
}
