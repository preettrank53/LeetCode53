class Solution {

    boolean helper(int mid , int[] weights , int days) {
        int count = 1 ;
        int sum = 0 ;
        for(int i = 0 ; i<weights.length ; i++) {
            if(weights[i] > mid) {
                return false;
            }
            sum = sum + weights[i];

            if(sum > mid ) {
                count++;
                sum = weights[i];
            }
            
        }

        return count<=days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int l = 1;
        int r = 0;

        for(int i = 0 ; i < n; i++) {
            r = r + weights[i];
        }

        int ans = 0;

        while(l<=r) {
            int mid = l + (r-l)/2;

            if(helper(mid , weights , days)) {
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