class Solution {
    int[][] dp;
    int fun(int i, int j,String s,String t ){
        if(i>=s.length()||j>=t.length()){
            return 0;
        }
        if(dp[i][j]!= -1){
            return dp[i][j];
        }
        int m = 0;
        if(s.charAt(i)==t.charAt(j)){
            int a=1 + fun(i + 1,j + 1,s,t);
            m = Math.max(m,a);
        }else{
            int a = fun(i + 1,j,s,t);
            int b = fun(i,j + 1,s,t);

            m = Math.max(m, a);
            m = Math.max(m, b);
    }
           return dp[i][j]=m;
    }
    public int longestCommonSubsequence(String text1, String text2) { 
        dp = new int[text1.length()][text2.length()];

        for(int i = 0;i<text1.length();i++){
            java.util.Arrays.fill(dp[i],-1);
        }
        return fun(0,0,text1,text2);
        
    }
}