#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    bool isSafe(vector<string>& board, int row, int col, int n) {
        // horizontal
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // vertical
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    void nQueen(vector<string>& board, int row, int n, vector<vector<string>>& result) {
        if (row == n) {
            result.push_back(board);  // Found a valid solution
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j, n)) {
                board[row][j] = 'Q';  // Place the queen

                nQueen(board, row + 1, n, result);  // Recur to place the next queen

                // Backtrack
                board[row][j] = '.';  // Reset the position
            }
        }
    }

    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> result;
        vector<string> board(n, string(n, '.'));  // Initialize board with empty rows

        nQueen(board, 0, n, result);

        return result;
    }
};
