class Solution {

    int index = 0;
    TreeNode helper(int[] pre, int[] post, int start, int end) {
        if (index >= pre.length || start > end) return null;

        TreeNode node = new TreeNode(pre[index]);
        index++;

        if (start == end || index >= pre.length) return node;

        int find = -1;
        for (int i = start; i <= end; i++) {
            if (post[i] == pre[index]) {
                find = i;
                break;
            }
        }

        if (find != -1) {
            node.left = helper(pre, post, start, find);
            node.right = helper(pre, post, find + 1, end - 1); 
        }

        return node;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder, postorder, 0, postorder.length - 1);
    }
}
