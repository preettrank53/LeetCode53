class Solution {
    int sumLeft = 0 ;
    int sumRight = 0 ;

    void helper(TreeNode node) {
        if(node == null) {
            return;
        }

        if(node.left != null) {
            sumLeft = sumLeft + node.left.val;
            helper(node.left);
        }
        if(node.right != null) {
            sumRight = sumRight + node.right.val;
            helper(node.right);
        }
    }

    public boolean checkTree(TreeNode root) {
        helper(root);
        if(sumLeft + sumRight == root.val) {
            return true;
        }
        return false;
    }
}