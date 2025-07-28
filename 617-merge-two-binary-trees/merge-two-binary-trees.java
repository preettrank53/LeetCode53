class Solution {

    TreeNode helper(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode newTree = new TreeNode(root1.val + root2.val);

        // Left child merge
        if (root1.left != null && root2.left != null) {
            newTree.left = helper(root1.left, root2.left);
        } else if (root1.left != null) {
            newTree.left = root1.left;
        } else if (root2.left != null) {
            newTree.left = root2.left;
        }

        // Right child merge
        if (root1.right != null && root2.right != null) {
            newTree.right = helper(root1.right, root2.right);
        } else if (root1.right != null) {
            newTree.right = root1.right;
        } else if (root2.right != null) {
            newTree.right = root2.right;
        }

        return newTree;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode ans = helper(root1, root2);
        return ans;
    }
}
