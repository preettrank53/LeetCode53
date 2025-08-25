class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0 ; i<n ; i++) {
            sum = sum + nums[i];
        }
        if(sum % 2 != 0) {
            return false;
        }
        int target = sum/2;
        boolean[][] dp = new boolean[n][target+1];

        for(int i = 0 ; i<n ; i++) {
            dp[i][0] = true;
        }
        if(nums[0] >= 0 && nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for(int i = 1 ; i<n ; i++) {
            for(int j = 1 ; j<=target ; j++) {
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(nums[i] <= j) {
                    take = dp[i-1][j-nums[i]];
                }

                dp[i][j] = notTake || take;
            }
        }
        return dp[n-1][target];
    }
}