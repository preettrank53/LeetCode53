class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;


        int[] prefix = new int[n+1];
        prefix[0] = 0;
        for(int i = 0 ; i < n ; i++) {
            prefix[i+1] = prefix[i] ^ arr[i];
        }

        int[][] dp = new int[n][n];
        int count = 0;

        for(int i = n-1 ; i >= 0 ; i--) {
            for(int j = i+1 ; j < n ; j++) {
                int local = 0;
                for(int k = i+1 ; k <= j ; k++) {
                    int a = prefix[k] ^ prefix[i];      
                    int b = prefix[j+1] ^ prefix[k];    
                    if(a == b) {
                        local++;
                    }
                }
                dp[i][j] = local;
                count += local;
            }
        }

        return count;
    }
}
