class Solution {

    int maxLen = -1;

    TreeNode helper(TreeNode node) {
        if(node == null) {
            return null;
        }

        int left = height(node.left);
        int right = height(node.right);


        if(left > right ) {
            return helper(node.left);
        }
        else if (right > left) {
            return helper(node.right);
        }

        return node;

    }

    int height(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        return Math.max(left , right) + 1;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root);
    }
}