class Solution {
    
    public class pair{
        boolean retVal;
        int maxHt;

        pair(boolean retVal , int maxHt) {
            this.retVal = retVal;
            this.maxHt = maxHt;
        }
    }

    public pair helper(TreeNode node) {
        if(node == null) {
            return new pair(true , 0);
        }

        pair myAns = new pair(false , -1);

        pair leftSide = helper(node.left);
        pair rightSide = helper(node.right);

        myAns.maxHt = Math.max(leftSide.maxHt , rightSide.maxHt) + 1;
        if (!leftSide.retVal || !rightSide.retVal || Math.abs(leftSide.maxHt - rightSide.maxHt) > 1) {
            myAns.retVal = false;
        } else {
            myAns.retVal = true;
        }

        return myAns;
    }
     

    public boolean isBalanced(TreeNode root) {
        return helper(root).retVal;
    }
}