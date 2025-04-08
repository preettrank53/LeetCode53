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

    int idx = 0; // pass by value

    TreeNode solve(int[] preorder , int[] inorder , int start , int end ) {

        // base case
        if(start > end) {
            return null;
        }

        int rootNode = preorder[idx];
        idx++;
        int i = start;

        for( i = start ; i<end ; i++) {
            if(inorder[i] == rootNode) {
                break;
            }
        }

        

        TreeNode root = new TreeNode(rootNode);

        root.left = solve(preorder , inorder , start , i-1 );
        root.right = solve(preorder , inorder , i+1 , end );

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // int[] idx = new int[1] ;  // pass by value

        return solve(preorder , inorder , 0 , n-1 );
    }
}