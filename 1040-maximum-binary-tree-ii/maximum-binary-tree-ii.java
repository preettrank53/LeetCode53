class Solution {

    TreeNode helper(TreeNode node , int val) {
        if(node == null) {
            return new TreeNode(val);
        }

        if(val > node.val) {
            TreeNode root = new TreeNode(val);
            root.left = node;
            return root;
        }
        else {
            node.right = helper(node.right , val);
        }
        return node;
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        return helper(root , val);
    }
}