class Solution {

    int helper(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftVal = 0;
        int rightVal = 0;

        if(node.left != null) {
            leftVal = helper(node.left);
        }
        if(node.right != null) {
            rightVal = helper(node.right);
        }

        if(node.val == 3) {
            if( leftVal == 1 && rightVal == 1 ) {
                return 1;
            }
            else {
                return 0;
            }

        }
        if(node.val == 2) {
            if(leftVal == 1 || rightVal == 1) {
                return 1;
            }
            else {
                return 0;
            }
        }

        return node.val;

    }

    public boolean evaluateTree(TreeNode root) {
        int ans = helper(root);
        if(ans == 1) {
            return true;
        }
        return false;
    }
}