// 1. Distinct Subsequences

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}


// 2. Edit Distance

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m < n) {
            String temp = word1; word1 = word2; word2 = temp;
            m = word1.length(); n = word2.length();
        }

        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = n - i;

        for (int i = m - 1; i >= 0; i--) {
            int nextDp = dp[n];
            dp[n] = m - i;
            for (int j = n - 1; j >= 0; j--) {
                int temp = dp[j];
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[j] = nextDp;
                } else {
                    dp[j] = 1 + Math.min(dp[j],
                                Math.min(dp[j + 1], nextDp));
                }
                nextDp = temp;
            }
        }
        return dp[0];
    }
}