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

    TreeNode findPredecessor(TreeNode node) {
        while(node.right != null) {
            node = node.right;
        }

        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(key < root.val) {
            root.left = deleteNode(root.left , key);
        }
        else if(key > root.val) {
            root.right = deleteNode(root.right , key);
        }

        else {
            //root.val == null

            if(root.left==null && root.right==null) { //leaf Node
                return null;
            }

            if(root.left==null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }

            else { //2 child
               // 2 way  - inorder predecessor  // in left size max val node
                //       - inorder successer    // rightt min val node

                // here we use inorde predecessor ; 

                TreeNode node = findPredecessor(root.left);

                root.val = node.val ; // copy node val into root than delete node 

                root.left = deleteNode(root.left , node.val);

            }
        }

        return root;
    }
}