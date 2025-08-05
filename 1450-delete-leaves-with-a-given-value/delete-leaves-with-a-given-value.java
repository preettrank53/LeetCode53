class Solution {

    TreeNode helper(TreeNode node , int target) {
        if(node == null) {
            return null;
        }


        node.left = helper(node.left , target);

        node.right = helper(node.right , target);

        if((node.left == null && node.right == null) && node.val == target) {
            node = null;
            return null;
        }

        return node;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return helper(root , target);
        
    }
}