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
    
    void helper(TreeNode root, List<Integer> result, int currentSum) {
        if (root == null) {
            return;
        }

        currentSum = currentSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            result.add(currentSum);
            return;
        }

        helper(root.left, result, currentSum);
        helper(root.right, result, currentSum);
    }

    public int sumNumbers(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result, 0);

        int totalSum = 0;
        for (int num : result) {
            totalSum += num;
        }

        return totalSum;
    }
}
