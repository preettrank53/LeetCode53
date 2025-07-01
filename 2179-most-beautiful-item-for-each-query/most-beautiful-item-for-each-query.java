class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = queries.length;
        int m = items.length;

        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        // Create array to store original indices of queries
        int[][] qWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            qWithIndex[i][0] = queries[i];
            qWithIndex[i][1] = i;
        }

        // Sort query array based on price
        Arrays.sort(qWithIndex, (a, b) -> a[0] - b[0]);

        int[] price = new int[m];
        int[] beauty = new int[m];

        for (int i = 0; i < m; i++) {
            price[i] = items[i][0];
            beauty[i] = items[i][1];
        }

        int j = 0;
        int maxBeauty = 0;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int query = qWithIndex[i][0];
            int originalIndex = qWithIndex[i][1];

            while (j < m && price[j] <= query) {
                maxBeauty = Math.max(maxBeauty, beauty[j]);
                j++;
            }

            ans[originalIndex] = maxBeauty;
        }

        return ans;
    }
}
