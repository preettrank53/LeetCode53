class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Integer[][] pairs = new Integer[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = plantTime[i];
            pairs[i][1] = growTime[i];
        }
        // Sort pairs by growTime values in decreasing order
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        
        // Arrays.sort(pairs, (a, b) -> a[1] - b[1]); // ascending

        for (int i = 0; i < n; i++) {
            plantTime[i] = pairs[i][0];
            growTime[i] = pairs[i][1];
        }

        //here all sorting completed

        int maxBloomDays = 0;
        int prevPlantDays = 0;

        for(int i = 0 ; i<n ; i++) {
            int currPlantTime = plantTime[i];
            int currGrowtTime = growTime[i];

            prevPlantDays = prevPlantDays + currPlantTime;

            int currPlantBloomTime = prevPlantDays + currGrowtTime;
            maxBloomDays = Math.max(maxBloomDays , currPlantBloomTime);
        }

        return maxBloomDays;

    }
}