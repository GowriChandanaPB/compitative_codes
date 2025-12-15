// 1. 3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < target) j++;
                else k--;
            }
        }
        res.addAll(s);
        return res;
    }
}


// 2. Container With Most Water

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



// 3. Remove K Digits 


class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        Stack<Character> stk = new Stack<>();
        int i = 0;
        while(i < num.length()){
            while(k > 0 && !stk.isEmpty() && stk.peek() > num.charAt(i)){
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
            i++;
        } 
        while(k > 0){
            stk.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()) sb.append(stk.pop());
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        return sb.toString();

    }
}



// 4.

