class Solution {

    long helper(int[] time , long mid) {
        long totalTime = 0;
        for (int i = 0 ; i < time.length ; i++) {
            totalTime += mid / time[i];
        }
        return totalTime;
    }

    public long minimumTime(int[] time, int totalTrips) {
        // Find the max time in array to calculate upper bound
        long minTime = Integer.MAX_VALUE;
        for (int i = 0 ; i < time.length ; i++) {
            if (time[i] < minTime) {
                minTime = time[i];
            }
        }

        long l = 1;
        long r = minTime * totalTrips;
        long ans = r;

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (helper(time, mid) >= totalTrips) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
