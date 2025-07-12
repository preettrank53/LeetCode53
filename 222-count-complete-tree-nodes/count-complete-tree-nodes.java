
class Solution {

    int totalNode(TreeNode root) {
        if (root == null) return 0;
        return 1 + totalNode(root.left) + totalNode(root.right);
    }

    public int countNodes(TreeNode root) {
        return totalNode(root);
    }
}