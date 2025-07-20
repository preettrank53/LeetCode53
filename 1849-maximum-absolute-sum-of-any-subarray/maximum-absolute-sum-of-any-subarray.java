class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;

        int maxSum = Integer.MIN_VALUE;
        int curr1 = 0;

        int minSum = Integer.MAX_VALUE;
        int curr2 = 0;

        for(int i = 0 ; i<n ; i++) {
            curr1 = curr1 + nums[i];

            if(curr1 > maxSum ) {
                maxSum = curr1;
            }
            if(curr1 < 0) {
                curr1 = 0;
            }
        }

        for(int i = 0 ; i<n ; i++) {
            curr2 = curr2 + nums[i];

            if(curr2 < minSum ) {
                minSum = curr2;
            }
            if(curr2 > 0) {
                curr2 = 0;
            }
        }

        return Math.max(maxSum , Math.abs(minSum));
    }
}