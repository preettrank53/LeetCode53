class Solution {
    List<TreeNode> list = new ArrayList<>();

    void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        int n = list.size();
        int left = 0;
        int right = n-1;

        while(left < right) {
            int sum = list.get(left).val + list.get(right).val;

            if(sum == k) {
                return true;
            }
            else if(sum > k) {
                right--;
            }
            else {
                left++;
            }
        }

        return false;
    }
}