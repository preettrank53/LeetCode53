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

    void helper(TreeNode root ,  List<Integer> list) {
        if(root==null) {
            return;
        }

        if(root.left==null && root.right==null) {
            list.add(root.val);
        }

        else {
            helper(root.left , list);
            helper(root.right , list);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        // call helper for Tree --> 1
        helper(root1 , list1);
        // call helper for Tree --> 2
        helper(root2 , list2);

        if(list1.equals(list2)) {
            return true;
        }

        return false;

    }
}