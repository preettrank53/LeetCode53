class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Case 1: Rob from 0 to n-2
        int max1 = robLinear(nums, 0, n - 2);

        // Case 2: Rob from 1 to n-1
        int max2 = robLinear(nums, 1, n - 1);

        return Math.max(max1, max2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int len = end - start + 1;
        if (len == 1) return nums[start];
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[start + i] + dp[i - 2], dp[i - 1]);
        }
        return Math.max(dp[len-2] , dp[len - 1]);
    }
}
