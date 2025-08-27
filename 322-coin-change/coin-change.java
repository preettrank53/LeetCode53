class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int i = 0 ; i<n ; i++) {
            dp[i][0] = 0;
        }

        for(int j = 0 ; j<amount+1 ; j++) {
            if(j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            }
            else {
                dp[0][j] = (int)1e9;
            }
            
        }

        for(int i = 1 ; i<n ; i++) {
            for(int j = 1 ; j<amount+1 ; j++) {
                int notTake = dp[i-1][j];
                int take = (int)1e9;
                if(coins[i] <= j) {
                    take = 1 + dp[i][j - coins[i]];
                }

                dp[i][j] = Math.min(notTake , take);
            }
        }

        int ans = dp[n-1][amount];
        return (ans >= 1e9) ? -1 : ans;
    }
}