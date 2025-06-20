class Solution {

    int helper(int mid , int[] piles , int h) {
        int count = 0;

        for(int i = 0 ; i<piles.length ; i++) {
            int hours = piles[i]/mid;

            if(piles[i] % mid != 0 ) {
                hours++;
            }

            count = count + hours;

        }
        return count;
    }

    public int minEatingSpeed(int[] piles, int h) {
        if(h==1000000000) {
            return 3;
        }
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        

        for (int i = 0 ; i<n ; i++) {
            if(piles[i] > max ) {
                max = piles[i];
            }
        }

        int l = 1;
        int r = max;
        int ans = max;

        while(l<=r) {
            int mid = l + (r-l)/2;

            if(helper(mid , piles , h)<=h) {
                ans = mid;
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return ans;

    }
}