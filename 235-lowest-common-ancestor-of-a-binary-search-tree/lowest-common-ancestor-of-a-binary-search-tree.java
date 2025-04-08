/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) {
            return null;
        }

        if(root == p || root == q) {
            return root;
        }


        TreeNode leftN = new TreeNode();
        TreeNode rightN = new TreeNode();

        leftN = lowestCommonAncestor(root.left , p , q);
        rightN = lowestCommonAncestor(root.right , p , q);

        if(leftN != null && rightN != null) {
            return root;
        }

        if(leftN != null) {
            return leftN;
        }

       // if(rightN != null) {
            return rightN;
        // }
    }
}