class Solution {
    // for find right most
    int findRightMost(int[] nums , int target , int n) {
        int right_most = -1;

        int l = 0;
        int r = n-1;

        while(l<=r) {
            int mid = l + (r-l)/2;

            if(nums[mid]==target) {
                right_most = mid;
                l = mid + 1 ;
            }
            else if (nums[mid] < target) {
                l = mid + 1 ;
            }
            else {
                r = mid - 1 ;
            }
        }
        return right_most;
    }

    // for find left most
    int findLeftMost(int[] nums , int target , int n) {
        int left_most = -1;

        int l = 0;
        int r = n-1;

        while(l<=r) {
            int mid = l + (r-l)/2;

            if(nums[mid]==target) {
                left_most = mid;
                r = mid - 1 ;
            }
            else if (nums[mid] < target) {
                l = mid + 1 ;
            }
            else {
                r = mid - 1 ;
            }
        }
        return left_most;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int left_most = findLeftMost(nums , target , n) ;
        int right_most = findRightMost(nums , target , n) ;

        return new int[]{left_most , right_most};
    }
}