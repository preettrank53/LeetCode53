class Solution {

    int sum = 0;

    void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                sum = sum + node.left.val;
            }
            helper(node.left);
        }

        if (node.right != null) {
            helper(node.right);
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        helper(root);
        return sum;
    }
}
