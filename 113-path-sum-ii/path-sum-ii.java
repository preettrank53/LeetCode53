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

    void helper(List<List<Integer>> result , List<Integer> combi , TreeNode root , int targetSum ) {
        if(root==null) {
            return;
        }
        combi.add(root.val);

        if(root.left==null && root.right==null && root.val==targetSum) {
            result.add(new ArrayList<>(combi));
            
        } else {
            helper(result , combi , root.left , targetSum-root.val);
            helper(result , combi , root.right , targetSum-root.val);

        }


        // backtrack 
        combi.remove(combi.size()-1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combi = new ArrayList<>();

        helper(result , combi , root , targetSum);

        return result;
    }
}