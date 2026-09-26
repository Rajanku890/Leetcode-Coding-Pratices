class Solution {
    int[] dp;
    int fun(int i, int[][]pairs){
        if(i>=pairs.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int take = 0;
        for(int j=i+1; j<pairs.length;j++){
            if(pairs[j][0]>pairs[i][1]){
                take = Math.max(take, fun(j,pairs));
            }
        }
        take = 1+take;
        int notTake=fun(i + 1, pairs);
        return dp[i]=Math.max(take,notTake);
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a, b)-> a[0]-b[0]);

        dp= new int[pairs.length];
        Arrays.fill(dp,-1);

        return fun(0,pairs);
    }
}