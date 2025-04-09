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
    public boolean isCompleteTree(TreeNode root) {
        
        // like leetcode 199(using BFS)

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean past = false ;  // kya PAST me null node dekha hai ?

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();


            if(node == null) {
                past = true;
            }

            else {
                if(past==true) {
                    return false;
                }

                queue.add(node.left);
                queue.add(node.right);   // here does not check for left and right is null 
                                        //or not add into queue
            }
        }

        return true;


    }
}