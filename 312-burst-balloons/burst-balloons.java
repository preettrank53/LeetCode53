class Solution {
    int[][] memo;
    int helper(int[] arr , int i , int j) {

        if (i > j) return 0;

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(int k = i ; k<j+1 ; k++) {
            ans = arr[i-1] * arr[k] * arr[j+1] + helper(arr , i , k-1) + helper(arr , k+1 , j);
            if(ans > max) {
                max = ans ;
            }
        }

        return memo[i][j] = max;


    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];

        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        memo = new int[n+2][n+2];
        for(int i = 0 ; i<n+2 ; i++) {
            for(int j = 0 ; j<n+2 ; j++) {
                memo[i][j] = -1;
            }
        }

        return helper(arr , 1 , n);
    }
}