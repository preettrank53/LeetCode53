class Solution {

    Set<Integer> set = new HashSet<>();

    boolean helper(TreeNode node, int k) {
        if (node == null) return false;

        if (set.contains(k - node.val)) {
            return true;
        }

        set.add(node.val);

        return helper(node.left, k) || helper(node.right, k);
    }

    public boolean findTarget(TreeNode root, int k) {
        return helper(root, k);
    }
}
