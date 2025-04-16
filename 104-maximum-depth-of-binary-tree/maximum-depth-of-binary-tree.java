class Solution {

    int l = 0;
    int r = 0;

    void maxLength(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        // Update max depth
        if (root.left != null) {
            l = Math.max(l, level + 1);
        }

        if (root.right != null) {
            r = Math.max(r, level + 1);
        }

        maxLength(root.left, level + 1);
        maxLength(root.right, level + 1);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left==null && root.right==null) {
            return 1;
        }

        // Start from root at level 1
        maxLength(root, 1);

        // Add +1 to include root level
        return Math.max(l, r);
    }
}
