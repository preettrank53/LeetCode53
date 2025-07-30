class Solution {

    int sum = 0;
    int curr = 0;

    void helper(TreeNode node) {
        if (node == null) return;
        
        curr = curr * 2 + node.val;
        
        if (node.left == null && node.right == null) {
            sum = sum + curr;
        }
        
        helper(node.left);
        helper(node.right);
        
        curr = curr / 2;
    }

    public int sumRootToLeaf(TreeNode root) {

        helper(root);
        return sum;
    }
}
