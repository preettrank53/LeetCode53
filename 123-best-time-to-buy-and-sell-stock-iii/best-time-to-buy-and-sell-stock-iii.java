class Solution {
    int ans = 0;
    int[][][] memo;
    int helper(int[] prices , int i , int buy , int target) {

        if (i == prices.length || target == 0) {
            return 0;
        }

        if(memo[i][buy][target] != -1) {
            return memo[i][buy][target];
        }

        if(buy == 1) {
            ans = Math.max(-prices[i] + helper(prices , i+1 , 0 , target) , helper(prices , i+1 , 1 , target));
        }
        else {
            ans = Math.max(prices[i] + helper(prices , i+1 , 1 , target-1) , helper(prices , i+1 , 0 , target));
        }

        return memo[i][buy][target] = ans;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n][2][3];

        for(int i = 0 ; i<n ; i++) {
            for(int j = 0 ; j<2 ; j++) {
                for(int k = 0 ; k<3 ; k++) {
                    memo[i][j][k] = -1;
                }
                
            }
        }

        return helper(prices , 0 , 1 , 2 );
    }
}