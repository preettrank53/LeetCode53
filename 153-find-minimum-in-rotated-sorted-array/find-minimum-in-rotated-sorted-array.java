class Solution {

    int helper(int[] nums , int n) {
        int min = nums[0];
        int l = 1 ; 
        int r = n-1;

        while(l<=r) {
            int mid = l + (r-l)/2;

            if(nums[mid] > min) {
                l = mid + 1;
            }
            else if (nums[mid] < min) {
                min = nums[mid];
                r = mid-1;
            }
        }
        return min;
    }

    public int findMin(int[] nums) {
        int n = nums.length;
        int min = helper(nums , n);

        return min;
    }
}