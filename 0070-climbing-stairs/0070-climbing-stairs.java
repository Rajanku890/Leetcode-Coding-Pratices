class Solution {
    int[] dp = new int[46];
    int fun(int n, int currSteps){
        if(currSteps > n) return 0;
        if(currSteps == n) return 1;

        if(dp[currSteps] != -1) return dp[currSteps];
        int c1 = fun(n, currSteps+1);
        int c2 = fun(n, currSteps+2);
        return dp[currSteps] = c1+c2;
    
    }
    public int climbStairs(int n) {
      Arrays.fill(dp, -1);
      return fun(n,0);
    }
        
}