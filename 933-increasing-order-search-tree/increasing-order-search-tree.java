class Solution {
    TreeNode newTree = new TreeNode(-1);
    TreeNode curr = newTree;

    void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            helper(node.left);
        }

        curr.right = new TreeNode(node.val);
        curr = curr.right;

        if (node.right != null) {
            helper(node.right);
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return newTree.right;
    }
}
