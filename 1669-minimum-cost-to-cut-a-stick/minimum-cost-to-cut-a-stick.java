class Solution {
    int[][] memo;
    int helper(int[] cuts, int i, int j) {

        if (i > j) {
            return 0;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        int ans;
        int min = Integer.MAX_VALUE;

        for (int x = i; x <= j; x++) {
            ans = (cuts[j + 1] - cuts[i - 1])   
                + helper(cuts, i, x - 1)     
                + helper(cuts, x + 1, j);    

            min = Math.min(min, ans);
        }

        return memo[i][j] = min;
    }

    public int minCost(int m, int[] cuts) {
        int n = cuts.length;

        memo = new int[n+2][n+2];
        
        for(int i = 0 ; i<n+2 ; i++) {
            for(int j = 0 ; j<n+2 ; j++) {
                memo[i][j] = -1;
            }
        }

        int[] newCuts = new int[n + 2];

        newCuts[0] = 0;
        newCuts[n + 1] = m;
        for (int i = 0; i < n; i++) {
            newCuts[i + 1] = cuts[i];
        }

        Arrays.sort(newCuts);

        return helper(newCuts, 1, n); 
    }
}
