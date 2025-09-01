class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] prefixSum = new int[n][m];

        for(int i = 0 ; i<n ; i++) {
            prefixSum[i][0] = mat[i][0];
            for(int j = 1 ; j<m ; j++) {
                prefixSum[i][j] = prefixSum[i][j-1] + mat[i][j]; 
            } 
        }

        for(int j = 0 ; j<m ; j++) {
            for(int i = 1 ; i<n ; i++) {
                prefixSum[i][j] = prefixSum[i][j] + prefixSum[i-1][j];
            }
        }

        for(int i = 0 ; i<n ; i++) {
            for(int j = 0 ; j<m ; j++) {
                int r1 = ((i - k) <=0) ? 0 : (i-k);
                int c1 = ((j - k) <=0) ? 0 : (j-k);
                int r2 = ((i + k) < n) ? (i+k) : (n-1);
                int c2 = ((j + k) < m) ? (j+k) : (m-1);

                int total = prefixSum[r2][c2];
                int top = (r1 > 0) ? prefixSum[r1 - 1][c2] : 0;
                int left = (c1 > 0) ? prefixSum[r2][c1 - 1] : 0;
                int topLeft = (r1 > 0 && c1 > 0) ? prefixSum[r1 - 1][c1 - 1] : 0;

                mat[i][j] = total - top - left + topLeft; 
            }
        }
        return mat;
    }
}