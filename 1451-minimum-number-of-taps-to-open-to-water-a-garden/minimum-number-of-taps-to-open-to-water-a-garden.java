class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] startEnd = new int[n + 1];

        // Step 1: Convert each tap's range into max reachable endpoint for each start
        for (int i = 0; i < ranges.length; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            startEnd[start] = Math.max(startEnd[start], end);
        }

        int taps = 0;
        int currEnd = 0;
        int maxEnd = 0;

        // Step 2: Greedily jump to the farthest point
        for (int i = 0; i <= n; i++) {
            if (i > maxEnd) return -1; // Cannot reach this point

            if (i > currEnd) {
                taps++;
                currEnd = maxEnd;
            }

            maxEnd = Math.max(maxEnd, startEnd[i]);
        }

        return taps;
    }
}
