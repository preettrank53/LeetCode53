class Solution {
    public int minCost(int z, int[] cuts) {
        int n = cuts.length;
        Arrays.sort(cuts);

        int[] arr = new int[n+2];
        arr[0] = 0;
        arr[n+1] =  z;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = cuts[i];
        }


        int[][] dp = new int[n+2][n+2];     

        int m = arr.length;

        for(int i = m-2 ; i>=1 ; i--) {
            for(int j = i ; j<=n ; j++) {
                int min = Integer.MAX_VALUE;
                for(int k = i ; k<j+1 ; k++) {
                    int ans = ( arr[j+1] - arr[i-1] ) + dp[i][k-1] + dp[k+1][j];
                    if(ans < min) {
                        min = ans;
                    }
                }

                dp[i][j] = min;
            }
        } 
        
        return dp[1][m-2];
    }
}