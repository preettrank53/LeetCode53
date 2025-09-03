class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int i = 0 ;
        int j = 0;

        Map<Integer , Integer> map = new HashMap<>();
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while(j < n) {
            sum = sum + nums[j];

            while(sum >= target) {
                minLen = Math.min(minLen , j-i+1);
                sum = sum - nums[i];
                i++;
            }
             
            j++;

        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}