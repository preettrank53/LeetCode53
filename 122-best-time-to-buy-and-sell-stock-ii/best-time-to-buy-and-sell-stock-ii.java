class Solution {
    int ans = 0;
    int[][] memo;
    int helper(int[] price , int i , int buy) {

        if(i==price.length) {
            return 0;
        }
        
        if(memo[i][buy] != -1) {
            return memo[i][buy];
        }

        if(buy == 1) {
            ans = Math.max(-price[i] + helper(price , i+1 , 0) , helper(price , i+1 , 1));
        }
        else {
            ans = Math.max(price[i] + helper(price , i+1 , 1) , helper(price , i+1 , 0));
        }

        return memo[i][buy] = ans;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n][2];

        for(int i = 0 ; i<n ; i++) {
            for(int j = 0 ; j<2 ; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(prices , 0 , 1);
    }
}