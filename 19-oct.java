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


// 3. Merge Two Sorted Lists

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}


// 4. Best Time to Buy and Sell Stock

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit;
        int max_profit = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] <= min) min = prices[i];
            profit = prices[i] - min;
            if(max_profit < profit) max_profit = profit;
        }
        return max_profit;
    }
}


// 5. Valid Palindrome

class Solution {
    public boolean isPalindrome(String s) {
        String low = s.toLowerCase();
        String fin_str = s.replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = fin_str.length();
        while(left < right){
            if(fin_str.charAt(left) != fin_str.charAt(right)) return false;
            left++;
            right--;
        }        
        return true;
    }
}


// 6. Invert Binary Tree

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;

    }
}