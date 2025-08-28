class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];

        for(int i = 0 ; i<n+2 ; i++) {
            for(int j = 0 ; j<n+2 ; j++) {
                if(i > j) {
                    dp[i][j] = 0;
                } 
            }
        }

        int m = arr.length;

        for(int i = m-2 ; i>=1 ; i--) {
            for(int j = i ; j<=n ; j++) {
                int max = Integer.MIN_VALUE;
                for(int k = i ; k<j+1 ; k++) {
                    int ans = arr[i-1] * arr[k] * arr[j+1] + dp[i][k-1] + dp[k+1][j];
                    if(ans > max) {
                        max = ans;
                    }
                }

                dp[i][j] = max;
            }
        }

        return dp[1][m-2];
    }
}