class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        TreeNode node = new TreeNode();

        while(!queue.isEmpty()) {
            node = queue.poll();
            if(node.right != null) {
                queue.offer(node.right);
            }
            if(node.left != null) {
                queue.offer(node.left);
            }
        }

        return node.val;
    }
}