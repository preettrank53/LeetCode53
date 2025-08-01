class Solution {

    public class pair {
        int par;
        int ht;

        pair(int par, int ht) {
            this.par = par;
            this.ht = ht;
        }
    }

    public pair helper(TreeNode node, int target, int depth, int parent) {
        if (node == null) {
            return null;
        }

        if (node.val == target) {
            return new pair(parent , depth);
        }

        pair left = helper(node.left, target, depth + 1, node.val);
        if (left != null) return left;

        pair right = helper(node.right, target, depth + 1, node.val);
        if (right != null) return right;

        return null;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        pair p1 = helper(root, x, 0, -1);
        pair p2 = helper(root, y, 0, -1);

        return (p1.ht == p2.ht) && (p1.par != p2.par);
    }
}
