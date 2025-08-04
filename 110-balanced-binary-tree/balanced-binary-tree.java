class Solution {

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int x = height(root.left);
        int y = height(root.right);

        return Math.max(x, y) + 1;
    }

    boolean helper(TreeNode node) {
        if (node == null) {
            return true;
        }

        boolean left = helper(node.left);
        boolean right = helper(node.right);

        int x = height(node.left);
        int y = height(node.right);

        if (left!=true || right!=true) {
            return false;
        }

        if (Math.abs(x - y) > 1) {
            return false;
        }

        return true;
    }

    public boolean isBalanced(TreeNode root) {
        return helper(root);
    }
}
