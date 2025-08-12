class Solution {

    int helper(TreeNode node) {
        if(node == null) {
            return -1;
        }

        int left = height(node.left);
        int right = height(node.right);


        if(left >= right) {
            if(node.left != null)
            return helper(node.left);
        }
        else {
            if(node.right != null)
            return helper(node.right);
        }

        return node.val;
    }

    int height(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = height(node.left); 
        int right = height(node.right); 

        return Math.max(left , right) + 1;
    }

    public int findBottomLeftValue(TreeNode root) {
        return helper(root);
    }
}