class Solution {

    TreeNode helper(List<Integer> leftL, List<Integer> rightL, int rootVal) {
        TreeNode node = new TreeNode(rootVal);

        if (!leftL.isEmpty()) {
            int maxL = Integer.MIN_VALUE, idx = -1;
            for (int i = 0; i < leftL.size(); i++) {
                if (leftL.get(i) > maxL) {
                    maxL = leftL.get(i);
                    idx = i;
                }
            }

            List<Integer> ll = leftL.subList(0, idx);
            List<Integer> lr = leftL.subList(idx + 1, leftL.size());

            node.left = helper(new ArrayList<>(ll), new ArrayList<>(lr), maxL);
        }

        if (!rightL.isEmpty()) {
            int maxR = Integer.MIN_VALUE, idx = -1;
            for (int i = 0; i < rightL.size(); i++) {
                if (rightL.get(i) > maxR) {
                    maxR = rightL.get(i);
                    idx = i;
                }
            }

            List<Integer> rl = rightL.subList(0, idx);
            List<Integer> rr = rightL.subList(idx + 1, rightL.size());

            node.right = helper(new ArrayList<>(rl), new ArrayList<>(rr), maxR);
        }

        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        int index = -1;
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < index; i++) {
            list1.add(nums[i]);
        }

        for (int i = index + 1; i < n; i++) {
            list2.add(nums[i]);
        }

        return helper(list1, list2, maxVal);
    }
}
