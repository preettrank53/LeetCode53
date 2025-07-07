class Solution {

    boolean helper(long mid , int[] ranks , int cars) {
        long count=0;

        for(int i = 0 ; i < ranks.length ; i++) {
            long carfixed = (long)Math.sqrt(mid/ranks[i]);
            count = count + carfixed;
        }

        return count >= cars;
    }

    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;

        long l = 1;
        long r = 0;

        for(int i = 0 ; i < n ; i++) {
            if(ranks[i] > r) {
                r = ranks[i];
            }
        }

        r = r * cars * cars;
        long ans = 0;

        while(l <= r) {
            long mid = l + (r-l)/2;

            if(helper(mid , ranks , cars)) {
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