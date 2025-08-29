class Solution {
    int[] memo;
    int helper(int[] arr , int i , int k) {

        if(i >= arr.length) {
            return 0;
        }

        if(memo[i] != -1) {
            return memo[i];
        }

        int len = 0 ;
        int maxVal = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for(int j = i ; j<Math.min(arr.length , i+k) ; j++) {
            len++;
            maxVal = Math.max(maxVal , arr[j]);
            int ans = (maxVal * len) + helper(arr , j+1 , k); 
            maxAns = Math.max(maxAns , ans);
        }

        return memo[i] = maxAns;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        memo = new int[n];
        for(int i = 0 ; i<n ; i++) {
            memo[i] = -1;
        }

        return helper(arr , 0 , k);
    }
}