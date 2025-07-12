class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // If it's a leaf node, check if the current value completes the sum
        if (root.left == null && root.right == null) {
            return root.val == targetSum;     // why root.val==targetSum because last node is 
        }

        // Recur on left and right children with updated sum
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);

        return left || right;
    }
}
