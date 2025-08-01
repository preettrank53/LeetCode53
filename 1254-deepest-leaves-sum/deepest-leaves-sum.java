class Solution {
    public int deepestLeavesSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            int n = queue.size();
            TreeNode node = new TreeNode();
            int sum = 0;

            for(int i = 0 ; i<n ; i++) {
                node = queue.poll();
                sum = sum + node.val;
                
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }

            list.add(sum);

        }

        return list.get(list.size()-1);
    }
}