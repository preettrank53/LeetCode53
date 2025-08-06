class Solution {
    List<Integer> list = new ArrayList<>();

    void helper(TreeNode node) {
        if(node == null) {
            return;
        }

        if(node.left != null) {
            helper(node.left);
        }

        list.add(node.val);

        if(node.right != null) {
            helper(node.right);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        helper(root);

        return list.get(k-1);
    }
}