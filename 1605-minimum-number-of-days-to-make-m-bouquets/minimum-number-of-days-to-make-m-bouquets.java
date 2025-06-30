class Solution {

    boolean helper(int mid , int m , int k , int[] bloomDay) {
        int count = 0; // for flowers
        int bouquets = 0;

        
        for(int i = 0 ; i < bloomDay.length ; i++) {
            if(bloomDay[i] <= mid) {
                count++;
                if(count==k) {
                    bouquets++;
                    if(bouquets == m) {
                        return true;
                    }
                    count=0;
                }
            }
            else {
                count = 0;
            }
        }
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        int l = 1 ; 
        int r = 0 ; 

        for(int i = 0 ; i < n ; i++) {
            if(bloomDay[i] > r) {
                r = bloomDay[i];
            }
        }

        int mid = 0;
        int ans = -1;

        while(l<=r) {
            mid = l + (r-l)/2;

            if(helper(mid , m , k , bloomDay)) {
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