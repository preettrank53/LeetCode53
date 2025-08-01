class Solution {

    boolean helper(TreeNode node1 , TreeNode node2) {
        if(node1 == null && node2 == null) {
            return true;
        } 
        if(node1 == null || node2 == null) {
            return false;
        }

        if(node1.val != node2.val) {
            return false;
        }


        boolean x = helper(node1.left , node2.right);
        boolean y = helper(node1.right , node2.left);

        if(x == true && y == true) {
            return true;
        }

        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        return helper(root , root);
    }
}