class Solution {


    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;

        int maxVal = Integer.MIN_VALUE;
        int index = -1;
        for (int i = left; i <= right; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(nums[index]);
        root.left = helper(nums, left, index - 1);
        root.right = helper(nums, index + 1, right);
        
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    
}
