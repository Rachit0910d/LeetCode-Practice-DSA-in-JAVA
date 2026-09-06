class Solution {
    
    private Integer[][] dp;
    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];
        return helper(s,t,0,0);
    }

    private int helper(String s, String t, int i, int j){
        if(j == t.length()){
            return 1;
        }

        if(i == s.length()){
            return 0;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = helper(s, t, i+1, j) + helper(s, t, i+1, j+1);
        } else{
            dp[i][j] = helper(s, t, i+1, j);
        }

        return dp[i][j];
    }
}