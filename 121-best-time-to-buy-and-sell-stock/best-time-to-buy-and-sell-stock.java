class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int min = prices[0];
        int maxVal = 0;

        for(int i = 1 ; i<n ; i++) {
            int cost = prices[i] - min;
            maxVal = Math.max(maxVal , cost);
            min = Math.min(min , prices[i]);
        }
        return maxVal;
    }
}