class Solution {

    int[][] memo;
    int helper(int[] coins , int amount , int i) {
        if(i == 0) {
            if (amount % coins[0] == 0) return 1;
            return 0;
        }

        if(memo[i][amount] != -1) {
            return memo[i][amount];
        }

        int notTake = helper(coins , amount , i-1);
        int take = 0;
        if(coins[i] <= amount) {
            take = helper(coins , amount - coins[i] , i);
        }

        return memo[i][amount] = notTake + take;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        memo = new int[n][amount+1];

        for(int i = 0 ; i<n ; i++) {
            for(int j = 0 ; j<amount+1 ; j++) {
                memo[i][j] = -1;
            }
        }

        return helper(coins , amount , n-1 );
    }
}