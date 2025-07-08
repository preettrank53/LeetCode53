class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;       // number of rows
        int n = matrix[0].length;    // number of columns

        int row = 0;         // Start from top-right corner
        int col = n - 1;

        while (row < m && col >= 0) {
            int current = matrix[row][col];

            if (current == target) {
                return true;
            } else if (current > target) {
                col--;  // move left
            } else {
                row++;  // move down
            }
        }

        return false;  // target not found
    }
}
