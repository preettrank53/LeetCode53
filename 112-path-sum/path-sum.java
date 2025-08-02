class Solution {

    int sum = 0;

    boolean helper(TreeNode node , int target) {
        if(node == null) {
            return false;
        }

        sum = sum + node.val;

        if((node.left == null && node.right == null ) && sum == target) {
            return true;
        }
        boolean x = false;
        boolean y = false;

        if(node.left != null) {
            x = helper(node.left , target);
        }

        if(node.right != null) {
            y = helper(node.right , target);
        }
        
            sum = sum - node.val;

        return x || y;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root , targetSum);
    }
}