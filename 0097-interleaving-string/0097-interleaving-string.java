class Solution {

    int[][][] dp = new int[101][101][201];

    int fun(int i, int j, int k, String s, String t, String str) {
        if (i >= s.length()) {

            while (j < t.length() && k < str.length()) {
                if (t.charAt(j) == str.charAt(k)) {
                    j++;
                    k++;
                } else {
                    return 0;
                }
            }

            return 1;
        }
        if (j >= t.length()) {

            while (i < s.length() && k < str.length()) {
                if (s.charAt(i) == str.charAt(k)) {
                    i++;
                    k++;
                } else {
                    return 0;
                }
            }

            return 1;
        }
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        int m = 0;
        if (s.charAt(i) == str.charAt(k)) {
            int a = fun(i + 1, j, k + 1, s, t, str);
            m = m | a;
        }
        if (t.charAt(j) == str.charAt(k)) {
            int b = fun(i, j + 1, k + 1, s, t, str);
            m = m | b;
        }

        if (s.charAt(i) != str.charAt(k) &&
            t.charAt(j) != str.charAt(k)) {
            return 0;
        }

        return dp[i][j][k] = m;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 201; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return fun(0, 0, 0, s1, s2, s3) == 1;
    }
}