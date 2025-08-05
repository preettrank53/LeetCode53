class Solution {

    TreeNode helper(TreeNode node , int target) {
        if(node == null) {
            return new TreeNode(target);
        }

        if(node.val > target) {
            node.left = helper(node.left , target);
        }
        if(node.val < target) {
            node.right = helper(node.right , target);
        }

        return node;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        return helper(root , val);
    }
}