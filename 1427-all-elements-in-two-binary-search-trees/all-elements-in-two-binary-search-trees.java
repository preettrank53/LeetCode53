class Solution {

    void helper(TreeNode node , List<Integer> list) {
        if(node == null) {
            return;
        }

        if(node.left != null) {
            helper(node.left , list);
        }

        list.add(node.val);

        if(node.right != null) {
            helper(node.right , list);
        }

        return;
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        helper(root1 , list);
        helper(root2 , list);

        Collections.sort(list);


        return list;




    }
}