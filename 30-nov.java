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


// 2. Merge k Sorted Lists

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> node = new ArrayList<>();
        for (ListNode lst : lists) {
            while (lst != null) {
                node.add(lst.val);
                lst = lst.next;
            }
        }
        Collections.sort(node);

        ListNode res = new ListNode(0);
        ListNode temp = res;
        for (int i : node) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return res.next;
    }
}


// 3. Largest Rectangle in Histogram

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> d = new ArrayDeque<>();
        int max_area = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int curr_len = (i == n) ? 0 : heights[i];

            while (!d.isEmpty() && curr_len < heights[d.peek()]) {
                int height = heights[d.pop()];
                int width = d.isEmpty() ? i : i - d.peek() - 1;
                max_area = Math.max(max_area, height * width);
            }
            d.push(i);
        }

        return max_area;    
    }
}