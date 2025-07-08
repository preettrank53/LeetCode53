class Solution {

    boolean helper(int l , int r , int target , int[] matrix) {
        while(l<=r) {
            int mid = l + (r-l)/2;

            if(target==matrix[mid]) {
                return true;
            }
            else if (target < matrix[mid]) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0 ; i<n ; i++) {
            if(helper(0 , m-1 , target , matrix[i] )) {
                return true;
            }
        }

        return false;

    }
}