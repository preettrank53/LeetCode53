class Solution {
    int sum = 0 ;

    void helper(TreeNode node) {
        if(node == null) {
            return;
        }

        if(node.right != null) {
            helper(node.right);
        }

        sum = sum + node.val;
        node.val = sum;

        if(node.left != null) {
            helper(node.left);
        }
    }

    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
}