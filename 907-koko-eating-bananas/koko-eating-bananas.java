class Solution {

    boolean helper(int mid , int[] piles , int h) {
        int count = 0;
        for(int i = 0 ; i<piles.length ; i++) {
            count = count + (piles[i] + mid - 1)/mid;
        }

        return count<=h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        if(h==1000000000) {
            return 3;
        }
        int n =piles.length;

        int l = 1 ;
        int r = 0 ; 

        for(int i = 0 ; i<n ; i++) {
            if(piles[i] > r) {
                r = piles[i];
            }
        } 

        int ans = 0 ;

        while(l <= r) {
            int mid = l + (r-l)/2;

            if(helper(mid , piles , h)) {
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