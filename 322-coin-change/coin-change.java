class Solution {
    int[][] memo;
    int helper(int[] coins , int amount , int i) {
        if (amount == 0) return 0;
        if(i == 0) {
            if(amount % coins[0] == 0) {
                return amount/coins[0];
            }
            return (int)1e9;
        }

        if(memo[i][amount] != -1) {
            return memo[i][amount];
        }

        int notTake = helper(coins , amount , i-1);
        int take = (int)1e9;
        if(coins[i] <= amount) {
            take = 1 + helper(coins , amount - coins[i] , i);
        }

        return memo[i][amount] = Math.min(notTake , take);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        memo = new int[n][amount+1];

        for(int i = 0 ; i<n ; i++) {
            for(int j = 0 ; j<amount+1 ; j++) {
                memo[i][j] = -1;
            }
        }

        int ans =  helper(coins , amount , n-1 );
        return (ans >= (int)1e9) ? -1 : ans;
    }
}