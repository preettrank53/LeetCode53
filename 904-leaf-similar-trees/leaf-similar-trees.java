class Solution {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    void helper1(TreeNode node) {
        if(node == null) {
            return;
        }

        if(node.left != null) {
            helper1(node.left);
        }
        if(node.right != null) {
            helper1(node.right);
        }

        if(node.left == null && node.right == null) {
            list1.add(node.val);
        }
    }
    void helper2(TreeNode node) {
        if(node == null) {
            return;
        }

        if(node.left != null) {
            helper2(node.left);
        }
        if(node.right != null) {
            helper2(node.right);
        }

        if(node.left == null && node.right == null) {
            list2.add(node.val);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        helper1(root1);
        helper2(root2);

        return list1.equals(list2);
    }
}