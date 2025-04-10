/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    long long kthLargestLevelSum(TreeNode* root, int k) {
        if (!root) return -1;

        queue<TreeNode*> q;
        q.push(root);

        vector<long long> levelSum;

        while (!q.empty()) {
            int n = q.size();
            long long sum = 0;

            for (int i = 0; i < n; ++i) {
                TreeNode* node = q.front();
                q.pop();
                sum += node->val;

                if (node->left) q.push(node->left);
                if (node->right) q.push(node->right);
            }

            levelSum.push_back(sum);
        }

        // Sort in descending order
        sort(levelSum.begin(), levelSum.end(), greater<long long>());

        if (k <= levelSum.size()) {
            return levelSum[k - 1];
        }

        return -1;
    }
};
