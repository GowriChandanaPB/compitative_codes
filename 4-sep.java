// 1. Generate Parentheses

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            res.add(new ArrayList<>());
        }
        res.get(0).add("");

        for (int k = 0; k <= n; k++) {
            for (int i = 0; i < k; i++) {
                for (String left : res.get(i)) {
                    for (String right : res.get(k - i - 1)) {
                        res.get(k).add("(" + left + ")" + right);
                    }
                }
            }
        }

        return res.get(n);
    }
}


// 2. Daily Temperatures

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<temperatures.length; i++){
            int a = temperatures[i];
            while(!stack.isEmpty() && a>stack.peek()[0]){
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            } 
            stack.push(new int []{a, i});
        }
        return res;
    }
}


// 3. Car Fleet

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] car = new double[n][2];
        for(int i=0; i<n; i++){
            car[i][0] = position[i];
            car[i][1] = (double)(target - position[i]) / speed[i];
        }
        Arrays.sort(car, (a, b) -> Double.compare(b[0], a[0]));
        int fleet = 0;
        double time = 0;
        for(int i=0; i<n; i++){
            if(car[i][1] > time){
                fleet++;
                time = car[i][1];
            }
        }
        return fleet;
    }
}


// 4. Largest Rectangle In Histogram

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            left[i] = -1;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            right[i] = n;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            left[i] += 1;
            right[i] -= 1;
            max = Math.max(max, heights[i] * (right[i] - left[i] + 1));
        }
        return max;
    }
}


// 5. Binary Search

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

