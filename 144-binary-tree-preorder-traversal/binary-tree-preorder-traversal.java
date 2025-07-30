class Solution {
    List<Integer> list = new ArrayList<>();

    void helper(TreeNode node) {
        if(node == null) {
            return;
        }

        list.add(node.val);

        if(node.left != null) {
            helper(node.left);
        }
        if(node.right != null) {
            helper(node.right);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return list;
    }
}