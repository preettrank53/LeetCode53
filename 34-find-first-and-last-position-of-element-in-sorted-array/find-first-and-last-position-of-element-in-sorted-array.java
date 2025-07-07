class Solution {

    int startIdx(int[] nums , int target) {
        int n = nums.length;

        int l = 0;
        int r = n-1;
        int ans = -1;

        while(l<=r) {
            int mid = l + (r-l)/2;

            if(nums[mid]==target) {
                ans=mid;
                r=mid-1;
            }
            else if(nums[mid] < target) {
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return ans;
    }


    int endIdx(int[] nums , int target) {
        int n = nums.length;

        int l = 0;
        int r = n-1;
        int ans = -1;

        while(l<=r) {
            int mid = l + (r-l)/2;

            if(nums[mid]==target) {
                ans=mid;
                l = mid+1;
            }
            else if(nums[mid] < target) {
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return ans;
    }


    public int[] searchRange(int[] nums, int target) {
        int leftIdx = startIdx(nums, target);
        int rightIdx = endIdx(nums, target);

        return new int[]{leftIdx , rightIdx};
    }
}