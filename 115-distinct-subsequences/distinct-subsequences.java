class Solution {

    int[][] memo;
    
    int helper(String s , String t , int i , int j) {
        if(j < 0) {
            return 1;
        }
        if(i < 0) {
            return 0;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        if(s.charAt(i) == t.charAt(j)) {
            return memo[i][j] = helper(s , t , i-1 , j-1) + helper(s ,t , i-1 , j);
        }
        return memo[i][j] = helper(s , t , i-1 , j);
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        memo = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memo[i][j] = -1;
            }
        }
                
        return helper(s , t , n-1 , m-1);
    }
}