class Solution {

    public class pair {
        int dia;
        int ht;

        pair(int dia , int ht) {
            this.dia = dia;
            this.ht = ht;
        }

    }

    public pair helper(TreeNode node) {
        if(node == null) {
            return new pair(-1,-1);
        }

        pair myAns = new pair(-1,-1);

        pair leftNode = helper(node.left);
        pair rightNode = helper(node.right);

        int mydia = leftNode.ht + rightNode.ht + 2;

        myAns.dia = Math.max(Math.max(leftNode.dia , rightNode.dia) , mydia);
        myAns.ht = Math.max(leftNode.ht , rightNode.ht) + 1;

        return myAns;

    }

    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).dia;
    }
}