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

    int maxSum ; 

    int helper(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int l = helper(root.left);
        int r = helper(root.right);

        // case 1 
        int case1 = l + r + root.val;

        // case 2 - any one is best (l or r)
        int case2 = Math.max(l,r) + root.val;

        // case 3 - not select any one root not left and not right 
        int case3 = root.val;

        maxSum = Math.max(maxSum, Math.max(case1, Math.max(case2, case3)));

        return Math.max(case2 , case3); 
    }

    public int maxPathSum(TreeNode root) {
        
        maxSum = Integer.MIN_VALUE ;
        helper(root);

        return maxSum;
    }
}