class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0 ;
        int r = n-1 ; 

        while(l<=r) {

            // skip duplicates from left and right
            while(l < r && nums[l]==nums[l+1] ) {
                l++;
            }
            while(l < r && nums[r]==nums[r-1] ) {
                r--;
            }

            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if(nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1; 
                } else {
                    l = mid + 1; 
                }
            }
            else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1; 
                } else { 
                    r = mid - 1; 
                }
            }
        }
        return false;
    }
}