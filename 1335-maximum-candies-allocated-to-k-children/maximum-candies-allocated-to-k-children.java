class Solution {

    boolean helper(int mid , int[] candies , long k) {
        long count = 0;
        for(int i = 0 ; i<candies.length ; i++) {
            count += candies[i] / mid;
        }

        return count>=k;
    }

    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;

        int l = 1;
        int r = 0;

        for(int i = 0 ; i<n ; i++) {
            r = Math.max(r , candies[i]);
        }

        int ans = 0;


        while(l<=r) {
            int mid = l + (r-l)/2;

            if(helper(mid , candies , k)) {
                ans = mid;
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return ans;
    }
}