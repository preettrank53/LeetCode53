class Solution {

    int count = 0;
    int maxVal = Integer.MIN_VALUE;

    void helper(TreeNode node) {
        if(node == null) {
            return;
        }
        int oldMax = maxVal;
        maxVal = Math.max(maxVal , node.val);

        if(node.val == maxVal) {
            count++;
        }

        helper(node.left);
        helper(node.right);
        maxVal = oldMax;
    }

    public int goodNodes(TreeNode root) {
        helper(root);
        return count;
    }
}