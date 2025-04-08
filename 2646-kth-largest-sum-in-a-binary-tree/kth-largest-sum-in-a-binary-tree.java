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
    public long kthLargestLevelSum(TreeNode root, int k) {

        // here also we use levelorder traveersal like leetcode 199
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Long> levelSum = new ArrayList<>();

        while(!queue.isEmpty()) {
            int n = queue.size();

            long sum = 0;

            for(int i = 0 ; i<n ; i++) {
                TreeNode node = queue.poll();
                sum = sum + node.val;

                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
            }

            levelSum.add(sum);

        }


        // sort list with decresing order
        Collections.sort(levelSum);
        Collections.reverse(levelSum);

        // If k is valid, return the kth largest level sum
        if (k <= levelSum.size()) {
            return levelSum.get(k - 1);
        }

        // If k is invalid, return -1 or handle as per problem requirement
        return -1;
    }
}