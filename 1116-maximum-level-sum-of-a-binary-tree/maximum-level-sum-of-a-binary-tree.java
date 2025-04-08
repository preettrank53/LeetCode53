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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        
        int lavel = 1 ;
        int maxLavel = 1;
        int maxSum = Integer.MIN_VALUE;

        while(!queue.isEmpty()) {
            int n = queue.size();
            int sum = 0;

            TreeNode node = new TreeNode();
            for(int i = 0 ; i<n ; i++) {
                node = queue.poll();
                sum = sum + node.val;

                if(node.left!=null) {
                    queue.add(node.left);
                }

                if(node.right!=null) {
                    queue.add(node.right);
                }

            }

            if(sum>maxSum) {
                maxSum = sum;
                maxLavel = lavel;
            }

            lavel++;

            
        }

        return maxLavel;
    }
}