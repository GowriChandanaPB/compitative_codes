// 1. zigzag conversion

class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < rows.length; i++) rows[i] = new StringBuilder();
        
        int currRow = 0;
        boolean down = false;
        
        for(char c : s.toCharArray()){
            rows[currRow].append(c);
            if(currRow == 0 || currRow == numRows - 1) down = !down;
            currRow += down ? 1 : -1;
        }
        
        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows) result.append(row);
        return result.toString();
    }
}



// 2. Trapping Rain Water

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int water = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }

        return water;        
    }
}



// 3. Minimum Window Substring

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return new String();
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, stridx = 0;
        for (char c : t.toCharArray()) map[c]++;

        char[] chS = s.toCharArray();

        while (end < chS.length) {
            if (map[chS[end++]]-- > 0) count--;
            while (count == 0) {
                if (end - start < minLen) {
                    stridx = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) count++;
            }
        }
        return minLen == Integer.MAX_VALUE ? new String() :
                new String(chS, stridx, minLen);
    }
}



// 4. Container With Most Water

class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = 0;

        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            res = Math.max(res, area);
            if (heights[l] <= heights[r]) l++;
            else r--;
        }
        return res;
    }
}