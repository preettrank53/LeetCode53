class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0;
            for(int i = 0 ; i<n ; i++) {
                TreeNode node = queue.poll();
                sum = sum + (double)node.val;

                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(sum/(double)n);
        }
        return list;
    }
}