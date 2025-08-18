class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];
        for(int i = 0 ; i<m+1 ; i++) {
            for(int j = 0 ; j<n+1 ; j++) {
                dp[i][j] = 0;
            }
        }

        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();

        for(int i = 1 ; i<m+1 ; i++) {
            for(int j = 1 ; j<n+1 ; j++) {
                if(s1[i-1] == s2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}