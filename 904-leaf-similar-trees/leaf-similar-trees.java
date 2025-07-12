class Solution {

    void helper(TreeNode root , List<Integer> list) {
        if (root == null) {
            return;
        }

        helper(root.left , list);
        helper(root.right , list);

        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        helper(root1 , list1);
        helper(root2 , list2);

        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }

        return true;
    }
}
