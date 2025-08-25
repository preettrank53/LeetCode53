class Solution {

    Boolean[][] memo;

    boolean helper(int[] nums , int sum1 , int sum2 , int i) {
        if (i < 0) {
            return sum1 == sum2;
        }

        if (memo[i][sum1] != null) {
            return memo[i][sum1];
        }

        boolean notTake = helper(nums , sum1 + nums[i] , sum2 , i - 1);
        boolean take = helper(nums , sum1 , sum2 + nums[i] , i - 1);

        return memo[i][sum1] = (notTake || take);
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) total += num;

        memo = new Boolean[n][total + 1]; 
        return helper(nums , 0 , 0 , n - 1);
    }
}
