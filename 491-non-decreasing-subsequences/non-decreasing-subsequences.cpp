class Solution {
    void solve(set<vector<int>>& result, vector<int>& nums, int prev, int i, vector<int>& combi) {
        // Base condition
        if (i == nums.size()) {
            if (combi.size() >= 2) {
                result.insert(combi);
            }
            return;
        }

        if (nums[i] >= prev) {
            combi.push_back(nums[i]);
            solve(result, nums, nums[i], i + 1, combi);

            // Backtrack
            combi.pop_back();
        }

        // Also part of backtrack - skip current element
        solve(result, nums, prev, i + 1, combi);
    }

public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        set<vector<int>> result;
        vector<int> combi;

        solve(result, nums, -101, 0, combi);

        return vector<vector<int>>(result.begin(), result.end());
    }
};
