class Solution {
public:
    int maxRequest = INT_MIN;

    void helper(vector<vector<int>>& requests, vector<int>& net, int idx, int n, int count) {
        // Base case
        if (idx == requests.size()) {
            bool allZeros = true;
            for (int i = 0; i < n; ++i) {
                if (net[i] != 0) {
                    allZeros = false;
                    break;
                }
            }

            if (allZeros) {
                maxRequest = max(maxRequest, count);
            }
            return;
        }

        int from = requests[idx][0];
        int to = requests[idx][1];

        // Take the current request
        net[from]--;
        net[to]++;
        helper(requests, net, idx + 1, n, count + 1);

        // Backtrack
        net[from]++;
        net[to]--;

        // Skip the current request
        helper(requests, net, idx + 1, n, count);
    }

    int maximumRequests(int n, vector<vector<int>>& requests) {
        vector<int> net(n, 0);
        helper(requests, net, 0, n, 0);
        return maxRequest;
    }
};
