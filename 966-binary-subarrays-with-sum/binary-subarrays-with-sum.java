class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int k) {
        if (k < 0) return 0;
        int n = nums.length;
        int i = 0, sum = 0, count = 0;

        for (int j = 0; j < n; j++) {
            sum += nums[j];

            while (sum > k) {
                sum -= nums[i];
                i++;
            }

            count += (j - i + 1);

            
        }
        return count;
    }
}
