class Solution {

    int helper(int[] prefix , int l , int r) {
        return prefix[r+1] ^ prefix[l];
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefix = new int[n+1];

        prefix[0] = 0;

        for(int i = 1 ; i<n+1 ; i++) {
            prefix[i] = prefix[i-1] ^ arr[i-1];
        }

        int m = queries.length;

        int[] ans = new int[m];

        for(int i = 0 ; i<m ; i++) {
            ans[i] = helper(prefix , queries[i][0] , queries[i][1]);
        }

        return ans;
    }
}