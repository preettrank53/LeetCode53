class Solution {

    public final TreeNode getTargetCopy_01(final TreeNode node ,  final TreeNode target) {
        if(node.val == target.val) {
            return node;
        }

        if(node.left != null) {
            TreeNode leftAns = getTargetCopy_01(node.left , target);
            if(leftAns.val == target.val) {
                return leftAns;
            }
        }
        if(node.right != null) {
            TreeNode rightAns = getTargetCopy_01(node.right , target);
            if(rightAns.val == target.val) {
                return rightAns;
            }
        }
        return new TreeNode(-1);
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode ans = getTargetCopy_01(cloned , target);
        return ans;
    }
}