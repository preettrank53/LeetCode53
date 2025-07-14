class Solution {

    private long totalSum = 0;
    private long maxProduct = 0;
    private static final int MOD = 1_000_000_007;

    // Step 1: Calculate total sum of all nodes
    private long calculateTotalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + calculateTotalSum(root.left) + calculateTotalSum(root.right);
    }

    // Step 2: Calculate max product by splitting at each node
    private long calculateSubtreeSum(TreeNode root) {
        if (root == null) return 0;
        long left = calculateSubtreeSum(root.left);
        long right = calculateSubtreeSum(root.right);
        long subtreeSum = root.val + left + right;
        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);
        return subtreeSum;
    }

    public int maxProduct(TreeNode root) {
        totalSum = calculateTotalSum(root);       // First traversal to get total sum
        calculateSubtreeSum(root);                // Second traversal to get max product
        return (int)(maxProduct % MOD);           // Return result modulo 10^9+7
    }
}
