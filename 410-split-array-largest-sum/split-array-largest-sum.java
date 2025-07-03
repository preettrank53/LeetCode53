class Solution {

    boolean helper(int mid , int[] nums , int k) {
        int count = 1;
        int sum = 0 ;
        for(int i = 0 ; i<nums.length ; i++) {
            if(nums[i] > mid) {
                return false;
            }
            sum = sum + nums[i];
            if(sum > mid) {
                count++;
                sum = nums[i];
            }
        }
        return count<=k;
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        int l = 1;
        int r = 0;

        for(int i = 0 ; i<n ; i++) {
            r = r + nums[i];
        }

        int ans = 0;

        while(l <= r) {
            int mid = l + (r-l)/2;

            if(helper(mid , nums , k)) {
                ans = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return ans;
    }
}