class Solution {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<String> seen = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue; // Skip empty cells
                
                // Format for row, column, and grid checks
                String rowCheck = num + " in row " + i;
                String colCheck = num + " in col " + j;
                String boxCheck = num + " in box " + (i / 3) + "-" + (j / 3);

                // Check if the number already exists in the list
                if (seen.contains(rowCheck) || seen.contains(colCheck) || seen.contains(boxCheck)) {
                    return false; // Duplicate found
                }

                // Add checks to the list
                seen.add(rowCheck);
                seen.add(colCheck);
                seen.add(boxCheck);
            }
        }
        return true; // Valid Sudoku
    }
}