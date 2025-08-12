class Solution {
    int count = 0;

    void helper(TreeNode node, int[] freq) {
        if (node == null) return;

        freq[node.val]++;

        if (node.left == null && node.right == null) {
            int odd = 0;
            for (int i = 1; i <= 9; i++) {
                if (freq[i] % 2 != 0) {
                    odd++;
                }
            }
            if (odd <= 1) {
                count++;
            }
        }


        helper(node.left, freq);
        helper(node.right, freq);

        freq[node.val]--;
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] freq = new int[10];  // 1-indexed for values 1–9
        helper(root, freq);
        return count;
    }
}
