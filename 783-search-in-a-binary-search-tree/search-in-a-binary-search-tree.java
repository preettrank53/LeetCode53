class Solution {

    TreeNode helper(TreeNode node, int target) {
        if (node == null) {
            return null;
        }

        if (node.val == target) {
            return node;
        }

        if (target < node.val) {
            return helper(node.left, target);
        }

        if (target > node.val) {
            return helper(node.right, target);
        }

        return null;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        return helper(root, val);
    }
}
