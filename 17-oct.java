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


// 3. Interleaving String

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return dfs(0, 0, 0, s1, s2, s3);
    }

    private boolean dfs(int i, int j, int k, String s1, String s2, String s3) {
        if (k == s3.length()) {
            return (i == s1.length()) && (j == s2.length());
        }

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            if (dfs(i + 1, j, k + 1, s1, s2, s3)) {
                return true;
            }
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            if (dfs(i, j + 1, k + 1, s1, s2, s3)) {
                return true;
            }
        }

        return false;
    }
}