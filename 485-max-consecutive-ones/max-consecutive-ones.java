class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;

        int i = -1 ;
        int j = 0 ;

        int count = 0 ;

        while(j < n) {
            if(nums[j] != 0) {
                j++;
                continue;
            }

            count = Math.max(count , j-i-1);
            i = j;
            j++;

        }

        count = Math.max(count , j-i-1);

        return count;
    }
}