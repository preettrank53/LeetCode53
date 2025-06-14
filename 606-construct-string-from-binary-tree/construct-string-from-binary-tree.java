class Solution {

    void helper(TreeNode root , StringBuilder str) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            return; // No need to add anything, already handled in caller
        }

        if (root.left != null) {
            str.append('(');
            str.append(root.left.val);
            helper(root.left, str);
            str.append(')');
        } else if (root.right != null) {
            // Left is null but right exists → need empty ()
            str.append("()");
        }

        if (root.right != null) {
            str.append('(');
            str.append(root.right.val);
            helper(root.right, str);
            str.append(')');
        }
    }

    public String tree2str(TreeNode root) {
        StringBuilder str = new StringBuilder();
        str.append(root.val);
        helper(root, str);
        return str.toString();
    }
}
