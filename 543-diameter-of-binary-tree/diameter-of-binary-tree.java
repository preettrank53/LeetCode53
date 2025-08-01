class Solution {

    int maxDia = 0;

    int helper(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftHight = helper(node.left);
        int rightHight = helper(node.right);

        maxDia = Math.max(leftHight + rightHight , maxDia); 

        return Math.max(leftHight , rightHight) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxDia;
    }
}