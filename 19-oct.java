// 1. Two sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[] {map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}


// 2. Valid Parentheses

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') stack.push(')');
            else if(ch == '[') stack.push(']');
            else if(ch == '{') stack.push('}');
            else{
                if(stack.isEmpty() || stack.pop() != ch) return false;
            }
        }
        return stack.isEmpty();
    }
}