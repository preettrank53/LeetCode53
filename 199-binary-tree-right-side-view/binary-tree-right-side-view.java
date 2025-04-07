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

    void preOrder(TreeNode root , int lavel , List<Integer> result) {
        if(root==null) {
            return ;
        }

        if(result.size() < lavel) {
            result.add(root.val);
        }

        preOrder(root.right , lavel+1 , result);
        //backtrack
        preOrder(root.left , lavel+1 , result);
    }

    public List<Integer> rightSideView(TreeNode root) {
        // Using DFS

        List<Integer> result = new ArrayList<>();

        preOrder(root , 1 , result);

        return result;
    }
}