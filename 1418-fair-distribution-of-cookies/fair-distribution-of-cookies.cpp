class Solution {
    int minUnfair = INT_MAX;

    void result(vector<int>& cookies, vector<int>& child, int idx, int k) {
        // base case
        if (idx == cookies.size()) {
            int maxVal = 0;
            for (int i = 0; i < k; ++i) {
                maxVal = max(maxVal, child[i]);
            }
            minUnfair = min(minUnfair, maxVal);
            return;
        }

        for (int i = 0; i < k; ++i) {
            child[i] += cookies[idx];

            // explore
            result(cookies, child, idx + 1, k);

            // backtrack
            child[i] -= cookies[idx];

            if (child[i] == 0) {
                break; // pruning to avoid symmetric states
            }
        }
    }

public:
    int distributeCookies(vector<int>& cookies, int k) {
        vector<int> child(k, 0);
        result(cookies, child, 0, k);
        return minUnfair;
    }
};
