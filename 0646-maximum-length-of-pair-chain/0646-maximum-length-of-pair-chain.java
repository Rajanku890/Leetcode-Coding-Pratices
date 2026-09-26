class Solution {
    int[] dp;

    int fun(int i, int[][] pairs) {

        if (i >= pairs.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int id = pairs.length;

        int l = i + 1;
        int h = pairs.length - 1;

        while (l <= h) {

            int mid = l + (h - l) / 2;

            if (pairs[mid][0] > pairs[i][1]) {
                id = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        int take = 1 + fun(id, pairs);

        int notTake = fun(i + 1, pairs);

        return dp[i] = Math.max(take, notTake);
    }

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        dp = new int[pairs.length];
        Arrays.fill(dp, -1);

        return fun(0, pairs);
    }
}