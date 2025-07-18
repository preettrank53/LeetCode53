class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] pair = new int[n][2];

        // Store score and original index
        for (int i = 0; i < n; i++) {
            pair[i][0] = score[i];
            pair[i][1] = i;
        }

        // Sort by score descending
        Arrays.sort(pair, (a, b) -> b[0] - a[0]);

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            int idx = pair[i][1];
            if (i == 0) {
                result[idx] = "Gold Medal";
            } else if (i == 1) {
                result[idx] = "Silver Medal";
            } else if (i == 2) {
                result[idx] = "Bronze Medal";
            } else {
                result[idx] = String.valueOf(i + 1);
            }
        }

        return result;
    }
}
