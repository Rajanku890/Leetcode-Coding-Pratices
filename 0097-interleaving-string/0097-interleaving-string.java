class Solution {

    int[][] dp;

    int fun(int i, int j, String s1, String s2, String s3) {
        if (i == s1.length() && j == s2.length()) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int k = i + j;
        if (i < s1.length() &&
            s1.charAt(i) == s3.charAt(k)) {

            if (fun(i + 1, j, s1, s2, s3) == 1) {
                return dp[i][j] = 1;
            }
        }
        if (j < s2.length() &&
            s2.charAt(j) == s3.charAt(k)) {

            if (fun(i, j + 1, s1, s2, s3) == 1) {
                return dp[i][j] = 1;
            }
        }

        return dp[i][j] = 0;
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return fun(0, 0, s1, s2, s3) == 1;
    }
}