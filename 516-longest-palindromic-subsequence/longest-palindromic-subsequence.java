class Solution {
    public int longestPalindromeSubseq(String s1) {
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();
        int n = s1.length();

        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        int[][] dp = new int[n+1][n+1];

        for(int i = 1 ; i<n+1 ; i++) {
            for(int j = 1 ; j<n+1 ; j++) {
                if(ch1[i-1] == ch2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}