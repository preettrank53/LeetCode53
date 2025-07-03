class Solution {

    boolean helper(int mid , int[] quantities , int n) {
        int stores_needed = 0;
        for(int i = 0 ; i<quantities.length ; i++) {
            stores_needed += (quantities[i] + mid - 1) / mid;
        }

        return stores_needed <=n;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;

        int l = 1 ; 
        int r = 0 ;

        for(int i = 0 ; i<m ; i++) {
            if(quantities[i] > r) {
                r = quantities[i];
            }
        }

        int ans = 0 ;

        while(l<=r) {
            int mid = l + (r-l)/2;

            if(helper(mid , quantities , n)) {
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