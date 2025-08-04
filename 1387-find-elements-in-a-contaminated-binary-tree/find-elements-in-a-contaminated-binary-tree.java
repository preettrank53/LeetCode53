class FindElements {

    Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        if (root != null) {
            root.val = 0;         
            set.add(0);       
            helper(root);
        }
    }

    void helper(TreeNode root) {
        if (root.left != null) {
            root.left.val = 2 * root.val + 1;
            set.add(root.left.val);
            helper(root.left);
        }

        if (root.right != null) {
            root.right.val = 2 * root.val + 2;
            set.add(root.right.val);
            helper(root.right);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
