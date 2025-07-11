class Solution {

    int idx = 0;
    Map<Integer , Integer> map = new HashMap<>();

    TreeNode helper(int[] preorder , int start , int end) {
        if(start > end ) {
            return null;
        }

        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = map.get(rootVal);
        idx++;

        root.left = helper(preorder , start , rootIdx-1 );
        root.right = helper(preorder , rootIdx+1 , end );

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;

        for(int i = 0 ; i<n ; i++) {
            map.put(inorder[i] , i);
        }

        return helper(preorder , 0 , n-1);

    }
}