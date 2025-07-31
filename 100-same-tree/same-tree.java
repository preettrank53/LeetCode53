class Solution {

    void helper(TreeNode node , List<Integer> list) {
        if(node == null) {
            list.add(-1);
            return;
        }

        helper(node.left , list);
        list.add(node.val);
        helper(node.right , list);
        list.add(node.val);
    
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<>();
        if(p != null) {
            list1.add(p.val);
            helper(p , list1);
        }
        List<Integer> list2 = new ArrayList<>();
        if(q != null) {
            list2.add(q.val);
            helper(q , list2);
        }
        
        return list1.equals(list2);
    }
}