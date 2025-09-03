class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        int i = 0 ; 
        int j = 0 ; 
        double sum = 0 ; 
        double avg = 0;
        double maxAvg = Integer.MIN_VALUE;

        while (j<n) {
            sum = sum + nums[j];
            avg = sum / k;

            while(j-i+1 == k) {
                maxAvg = Math.max(maxAvg , avg);
                sum = sum - nums[i];
                i++;
            }

            j++;
        }

        return maxAvg;
    }
}