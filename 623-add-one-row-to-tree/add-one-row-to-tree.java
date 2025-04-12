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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int lavel = 1 ;

        while(!queue.isEmpty()) {
            int n = queue.size();

            if(lavel==depth-1) {
                
                for(int i = 0 ; i<n ; i++) {
                    TreeNode node = queue.poll();

                    TreeNode tempLeft = node.left;
                    TreeNode tempRight = node.right;

                    node.left = new TreeNode(val);
                    node.right = new TreeNode(val);

                    node.left.left = tempLeft;
                    node.right.right = tempRight;
                }
                
                break;
            }

            TreeNode node = new TreeNode();
            for(int i = 0 ; i<n ; i++) {
                node = queue.poll();

                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }

            lavel++;
        }

        return root;
    }
}