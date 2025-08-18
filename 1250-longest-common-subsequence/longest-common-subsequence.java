class Solution {

    int[][] memo;

    int helper(String s1 , String s2 , int i , int j) {
        if(i >= s1.length() || j >= s2.length()) {
            return 0;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            return memo[i][j] = 1 + helper(s1 , s2 , i+1 , j+1);
        } else {
            return memo[i][j] = Math.max(
                helper(s1 , s2 , i , j+1), 
                helper(s1 , s2 , i+1 , j)
            );
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        memo = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                memo[i][j] = -1;
            }
        }

        return helper(text1 , text2 , 0 , 0);
    }
}
