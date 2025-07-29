class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftSum = maxDepth(root.left);
        int rightSum = maxDepth(root.right);

        return Math.max(leftSum , rightSum ) + 1 ;
    }

}