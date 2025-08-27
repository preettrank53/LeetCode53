class Solution {
    int ans = 0;
    int[][] memo;
    int helper(int[] price , int i , int buy , int fee) {

        if(i==price.length) {
            return 0;
        }
        
        if(memo[i][buy] != -1) {
            return memo[i][buy];
        }

        if(buy == 1) {
            ans = Math.max(-price[i] + helper(price , i+1 , 0 , fee) , helper(price , i+1 , 1 , fee));
        }
        else {
            ans = Math.max(price[i] + helper(price , i+1 , 1 , fee) - fee , helper(price , i+1 , 0 , fee));
        }

        return memo[i][buy] = ans;
    }

    public int maxProfit(int[] prices , int fee) {
        int n = prices.length;
        memo = new int[n][2];

        for(int i = 0 ; i<n ; i++) {
            for(int j = 0 ; j<2 ; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(prices , 0 , 1 , fee);
    }
}