class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1]; 
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int len = 0;
            int maxVal = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;

            for (int j = i; j < Math.min(n, i + k); j++) {
                len++;
                maxVal = Math.max(maxVal, arr[j]);
                int ans = (maxVal * len) + dp[j + 1];
                maxAns = Math.max(maxAns, ans);
            }

            dp[i] = maxAns;
        }

        return dp[0];
    }
}
