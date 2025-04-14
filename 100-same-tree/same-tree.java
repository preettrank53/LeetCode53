class Solution {

    void sameTree(TreeNode root , List<String> list) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                list.add("null");
                continue;
            }

            list.add(String.valueOf(node.val));
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        sameTree(p , list1);
        sameTree(q , list2);

        return list1.equals(list2);
    }
}
