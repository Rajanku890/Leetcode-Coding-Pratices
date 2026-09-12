class Solution {

    int[][] dp;

    int fun(int p, int i, int[] nums, int m, int k) {

        if (i >= nums.length) {
            return 0;
        }

        if (dp[i][p] != -1) {
            return dp[i][p];
        }

        m = Math.max(m, nums[i]);

        int len = i - p + 1;

        int ans = 0;

        if (len == k) {

            int c1 = (m * len) + fun(i + 1, i + 1, nums, 0, k);

            ans = Math.max(ans, c1);

        } else {

            int c1 = (m * len) + fun(i + 1, i + 1, nums, 0, k);

            int c2 = fun(p, i + 1, nums, m, k);

            ans = Math.max(c1, c2);
        }

        return dp[i][p] = ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {

        dp = new int[arr.length][arr.length];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return fun(0, 0, arr, 0, k);
    }
}