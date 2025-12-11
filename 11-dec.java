// 1. Number of Subsequences That Satisfy the Given Sum Condition

class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1000000007 , n = nums.length;
        Arrays.sort(nums);
        
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) power[i] = (power[i - 1] * 2) % mod;
        int left = 0 , right = n - 1 , result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + power[right - left]) % mod;
                left++;
            } else right--;
        }
        return result;
    }
}



// 2. Two Sum IV - Input is a BST

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set=new HashSet<>();
        return helper(root,k,set);
    }
    public boolean helper(TreeNode node,int k,Set<Integer> seen){
        if(node==null)  return false;
        if(seen.contains(k-node.val)) return true;
        seen.add(node.val);
        return helper(node.left,k,seen) || helper(node.right,k,seen);
    }
}