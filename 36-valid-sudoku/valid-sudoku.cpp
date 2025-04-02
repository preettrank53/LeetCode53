class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<string> seen; // Using vector instead of unordered_set

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue; // Skip empty cells

                // Row, Column, and Box (3x3) Validation
                string rowCheck = string(1, num) + " in row " + to_string(i);
                string colCheck = string(1, num) + " in col " + to_string(j);
                string boxCheck = string(1, num) + " in box " + to_string(i / 3) + "-" + to_string(j / 3);

                // If any of these exist in the list, it's an invalid Sudoku
                if (find(seen.begin(), seen.end(), rowCheck) != seen.end() ||
                    find(seen.begin(), seen.end(), colCheck) != seen.end() ||
                    find(seen.begin(), seen.end(), boxCheck) != seen.end()) {
                    return false;
                }

                // Add constraints to the list
                seen.push_back(rowCheck);
                seen.push_back(colCheck);
                seen.push_back(boxCheck);
            }
        }
        return true; // Sudoku is valid
    }
};