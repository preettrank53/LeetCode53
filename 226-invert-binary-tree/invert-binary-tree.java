class Solution {

    void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        helper(node.left);
        helper(node.right);

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null; 
        helper(root);
        return root;
    }
}
