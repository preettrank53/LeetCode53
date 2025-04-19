
class Solution {
    void sameTree(TreeNode* root, vector<string>& list) {
        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()) {
            TreeNode* node = q.front();
            q.pop();

            if (node == nullptr) {
                list.push_back("null");
                continue;
            }

            list.push_back(to_string(node->val));
            q.push(node->left);
            q.push(node->right);
        }
    }

public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        vector<string> list1, list2;
        sameTree(p, list1);
        sameTree(q, list2);

        return list1 == list2;
    }
};
