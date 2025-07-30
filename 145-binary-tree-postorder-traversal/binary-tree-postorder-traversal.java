class Solution {

    List<Integer> list = new ArrayList<>();

    void helper(TreeNode node) {
        if(node == null) {
            return;
        }

        if(node.left != null) {
            helper(node.left);
        }
        if(node.right != null) {
            helper(node.right);
        }

        list.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return list;
    }
}