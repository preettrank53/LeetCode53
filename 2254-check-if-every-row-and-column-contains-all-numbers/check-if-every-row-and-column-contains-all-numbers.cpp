class Solution {
public:
    bool checkValid(vector<vector<int>>& matrix) {
        int n = matrix.size();
        unordered_set<string> seen;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];

                // Create row and column checks
                string rowCheck = to_string(num) + " in row " + to_string(i);
                string colCheck = to_string(num) + " in col " + to_string(j);

                // Check for duplicates
                if (seen.count(rowCheck) || seen.count(colCheck)) {
                    return false;
                }

                // Add constraints to the set
                seen.insert(rowCheck);
                seen.insert(colCheck);
            }
        }
        return true;
    }
};