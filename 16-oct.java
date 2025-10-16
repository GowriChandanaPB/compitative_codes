// 1. Maximum Subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int sub = nums[0], sum = 0;
        for (int i : nums) {
            if (sum < 0) {
                sum = 0;
            }
            sum += i;
            sub = Math.max(sub, sum);
        }
        return sub;
    }
}


// 2. Unique Paths

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[j] += dp[j + 1];
            }
        }

        return dp[0];
    }
}


// 3. Longest Common Subsequence  

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int[] dp = new int[text2.length() + 1];

        for (int i = text1.length() - 1; i >= 0; i--) {
            int prev = 0;
            for (int j = text2.length() - 1; j >= 0; j--) {
                int temp = dp[j];
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[j] = 1 + prev;
                } else {
                    dp[j] = Math.max(dp[j], dp[j + 1]);
                }
                prev = temp;
            }
        }

        return dp[0];
    }