class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];

                // Create row and column checks
                String rowCheck = num + " in row " + i;
                String colCheck = num + " in col " + j;

                // Check for duplicates in the HashSet (O(1) lookup)
                if (seen.contains(rowCheck) || seen.contains(colCheck)) {
                    return false;
                }

                seen.add(rowCheck);
                seen.add(colCheck);
            }
        }

        return true;
    }
}