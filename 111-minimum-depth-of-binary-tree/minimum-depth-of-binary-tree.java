class Solution {

    int helper(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int x = helper(node.left);
        int y = helper(node.right);

        if(x == 0 || y == 0) {
            return Math.max(x, y) + 1;
        }

        return Math.min(x, y) + 1;
    }

    public int minDepth(TreeNode root) {
        return helper(root);
    }
}
