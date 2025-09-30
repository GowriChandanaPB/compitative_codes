// 1. Task Scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] count = new int[26];
        for(char i:tasks){
            count[i-'A']++;
        }
        Arrays.sort(count);
        int max = count[25];
        int idle = (max - 1) * n;

        for(int i=24; i>=0; i--){
            idle -= Math.min(max - 1, count[i]);
        }
        return Math.max(0, idle) + tasks.length;
    }
}


// 2. Find Median from Data Stream

class MedianFinder {
    public ArrayList<Integer> data;

    public MedianFinder() {
        data = new ArrayList<>();    
    }
    
    public void addNum(int num) {
        data.add(num);
    }
    
    public double findMedian() {
        Collections.sort(data);
        if((data.size() & 1) == 1){
            return data.get(data.size() / 2);
        } else {
            return (data.get(data.size() / 2) + data.get(data.size() / 2 - 1)) / 2.0;
        }
    }
}


// 3. Container With Most Water

public class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = 0;

        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            res = Math.max(res, area);
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}