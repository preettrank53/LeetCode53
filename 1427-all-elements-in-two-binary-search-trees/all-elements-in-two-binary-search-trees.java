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
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        helper(root1 , list1);
        helper(root2 , list2);

        int n = Math.min(list1.size() , list2.size());
        List<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                ans.add(list1.get(i++));
            } else {
                ans.add(list2.get(j++));
            }
        }

        while (i < list1.size()) ans.add(list1.get(i++));
        while (j < list2.size()) ans.add(list2.get(j++));


        return ans;




    }
}