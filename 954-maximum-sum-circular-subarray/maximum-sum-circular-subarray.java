class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int totalSum = 0;

       
        int currMax = 0, maxSum = nums[0];

        
        int currMin = 0, minSum = nums[0];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            totalSum += num;

            
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

           
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
        }

        
        if (totalSum == minSum)
            return maxSum;

        
        return Math.max(maxSum, totalSum - minSum);
    }
}
