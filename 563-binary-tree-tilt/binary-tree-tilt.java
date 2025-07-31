class Solution {
    int ans = 0;
    int helper(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftSum = 0;
        int rightSum = 0;

        if(node.left != null) {
            leftSum = helper(node.left);
        }
        if(node.right != null) {
            rightSum = helper(node.right);
        }

        ans = ans + Math.abs(leftSum - rightSum);
        return leftSum + rightSum + node.val ;
    }

    public int findTilt(TreeNode root) {
        helper(root);
        return ans;
    }
}