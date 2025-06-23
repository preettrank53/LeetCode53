class Solution {

    boolean helper(int[] dist , double hour , int mid) {
        double time = 0.0;

        for(int i = 0 ; i < dist.length ; i++) {
            double t = (double) dist[i] / mid;

            if(i != dist.length - 1) {
                time += Math.ceil(t); // round up for all except last
            } else {
                time += t; // last segment exact
            }
        }

        if(time > hour) {
            return false;
        }
        
        return true;
        
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;

        // Check if it's even possible
        if (hour <= n - 1) return -1;

        int l = 1;
        int r = (int) 1e7;
        int ans = 0;

        while(l<=r) {
            int mid = l+(r-l)/2;

            if(helper(dist , hour , mid)) {
                ans = mid;
                r = mid-1;
            } 
            else {
                l = mid + 1;
            }
        }
        return ans;
    }
}