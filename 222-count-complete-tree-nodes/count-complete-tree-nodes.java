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
    public int countNodes(TreeNode root) {

        if(root==null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int count = 0 ;

        while(!queue.isEmpty()) {
            int n = queue.size();

            for(int i = 0 ; i<n ; i++) {
                TreeNode node = queue.poll();
                count++;

                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
        }

        return count;

    }
}