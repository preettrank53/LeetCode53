class Solution {
    public int maxProfit(int k , int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for (int i = n-1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int t = 1; t < k+1; t++) {
                    if (buy == 1) {
                        dp[i][buy][t] = Math.max(-prices[i] + dp[i+1][0][t],
                                                 dp[i+1][1][t]);
                    } else {
                        dp[i][buy][t] = Math.max(prices[i] + dp[i+1][1][t-1],
                                                 dp[i+1][0][t]);
                    }
                }
            }
        }

        return dp[0][1][k]; 
    }
}