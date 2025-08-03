class Solution {

    int sum = 0;

    void helper(TreeNode node) {
        if (node == null) return;

        if (node.val % 2 == 0) {
            if (node.left != null && node.left.left != null) {
                sum += node.left.left.val;
            }
            if (node.left != null && node.left.right != null) {
                sum += node.left.right.val;
            }
            if (node.right != null && node.right.left != null) {
                sum += node.right.left.val;
            }
            if (node.right != null && node.right.right != null) {
                sum += node.right.right.val;
            }
        }

        helper(node.left);
        helper(node.right);
    }

    public int sumEvenGrandparent(TreeNode root) {
        helper(root);
        return sum;
    }
}
