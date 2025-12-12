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