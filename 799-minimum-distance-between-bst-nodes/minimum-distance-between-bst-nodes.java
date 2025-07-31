class Solution {

    int minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;

    void helper(TreeNode node) {
        if(node == null) {
            return;
        }

        if(node.left != null) {
            helper(node.left);
        }
        if(prev != null) {
            minDiff = Math.min(minDiff , node.val - prev.val);
        }
        prev = node;

        if(node.right != null) {
            helper(node.right);
        }

    }

    public int minDiffInBST(TreeNode root) {
        helper(root);
        return minDiff;
    }
}