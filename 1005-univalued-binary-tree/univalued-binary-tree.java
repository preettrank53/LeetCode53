class Solution {

    boolean helper(TreeNode node , int target) {
        if (node == null) return true;  

        if (node.val != target) {
            return false;
        }
        
        return helper(node.left, target) && helper(node.right, target);
    }

    public boolean isUnivalTree(TreeNode root) {
        return helper(root , root.val);
    }
}
