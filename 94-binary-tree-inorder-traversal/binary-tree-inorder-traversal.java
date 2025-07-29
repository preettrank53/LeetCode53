class Solution {
    List<Integer> ans = new ArrayList<>();

    void helper(TreeNode node) {
        if(node == null) {
            return;
        }

        helper(node.left);
        ans.add(node.val);
        helper(node.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return ans;
    }
}