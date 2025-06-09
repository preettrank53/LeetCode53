class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] L2R = new int[n];
        int[] R2L = new int[n];

        Arrays.fill(L2R , 1);
        Arrays.fill(R2L , 1);

        // this loop for L2R
        for(int i = 1 ; i<n ; i++) {
            if(ratings[i] > ratings[i-1]) {
                L2R[i] = Math.max(L2R[i] , L2R[i-1]+1);
            }
        }

        // this loop for R2L
        for(int i = n-2 ; i>=0 ; i--) {
            if(ratings[i] > ratings[i+1]) {
                R2L[i] = Math.max(R2L[i] , R2L[i+1]+1);
            }
        }

        int result = 0;
        for(int i = 0 ; i<n ; i++) {
            result = result + Math.max(L2R[i] , R2L[i]);
        }

        return result;
    }
}