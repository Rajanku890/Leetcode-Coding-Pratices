class Solution {
    int[][] dp;

    int fun(int i, int j, String s) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + fun(i + 1, j - 1, s);
        } 
        else {
            dp[i][j] = Math.max(
                fun(i + 1, j, s),
                fun(i, j - 1, s)
            );
        }

        return dp[i][j];
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return fun(0, n - 1, s);
    }
}