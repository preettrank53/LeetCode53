class Solution {
    public int numDistinct(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();

        int n = ch1.length;
        int m = ch2.length;

        int[][] dp = new int[n+1][m+1];
        // you already know what is this if you follow striver playlist
        for (int i = 0; i <n+1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <m+1; j++) {
            dp[0][j] = 0;
        }

        for(int i = 1 ; i<n+1 ; i++) {
            for(int j = 1 ; j<m+1 ; j++) {
                if(ch1[i-1] == ch2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}