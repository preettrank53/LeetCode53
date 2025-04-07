/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null) {
            return result;
        }

        queue.add(root);

        while(!queue.isEmpty()) {
            int n = queue.size();

            TreeNode node = new TreeNode();

            for(int i = 0 ; i < n ; i++) {
                node = queue.poll();
                
                if(i==n-1) {
                    result.add(node.val);
                }


                if(node.left!=null) {
                    queue.add(node.left);
                }

                if(node.right!=null) {
                    queue.add(node.right);
                }
            }

            
        }

        return result;
    }
}