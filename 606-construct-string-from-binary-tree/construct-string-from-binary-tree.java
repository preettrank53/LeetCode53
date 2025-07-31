class Solution {

    void helper(TreeNode node , StringBuilder sb) {
        if(node == null) {
            return;
        }

        if(node.left == null && node.right == null) {
            return;
        }

        sb.append('(');
        if(node.left != null) {
            sb.append(node.left.val);
            helper(node.left , sb);
        }
        sb.append(')');
        
        if(node.right != null) {
            sb.append('(');
            sb.append(node.right.val);
            helper(node.right , sb);
            sb.append(')');
        }
    }

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        helper(root , sb);
        return sb.toString();
    }
}