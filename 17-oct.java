// 1. coin change 2 

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = coins.length - 1; i >= 0; i--)
            for (int a = 1; a <= amount; a++)
                dp[a] = dp[a] + (coins[i] <= a ? dp[a - coins[i]] : 0);
        return dp[amount];
    }
}


// 2. Target Sum

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(0, 0, nums, target);
    }

    private int backtrack(int i, int total, int[] nums, int target) {
        if (i == nums.length) {
            return total == target ? 1 : 0;
        }
        return backtrack(i + 1, total + nums[i], nums, target) +
               backtrack(i + 1, total - nums[i], nums, target);
    }
}