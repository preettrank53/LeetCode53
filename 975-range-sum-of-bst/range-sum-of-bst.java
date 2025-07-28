class Solution {
    int nodeSum = 0;
    void helper(TreeNode node , int low , int high) {
        if(node == null) {
            return;
        }

        if(node.val >= low && node.val <= high) {
            nodeSum = nodeSum + node.val;
        }

        if(node.val >= low) {
            helper(node.left , low , high);
        }
        if(node.val <= high) {
            helper(node.right , low , high);
        }
    }
 
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root , low , high);
        return nodeSum;
    }
}