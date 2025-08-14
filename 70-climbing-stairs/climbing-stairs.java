class Solution {
    int[] memo;

    int helper(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }

        memo[n] = helper(n - 1) + helper(n - 2);
        return memo[n];
    }

    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return helper(n);
    }
}
