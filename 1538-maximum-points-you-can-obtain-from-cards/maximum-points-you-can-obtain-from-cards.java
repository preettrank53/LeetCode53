class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        int lSum = 0 ;
        for(int i =  0 ; i<k ; i++) {
            lSum = lSum + cardPoints[i];
        }

        int maxSum = lSum;
        int rSum = 0 ;
        int r = n-1;

        for(int i = k-1 ; i>=0 ; i--) {
            lSum = lSum - cardPoints[i];
            rSum = rSum + cardPoints[r];
            r--;

            maxSum = Math.max(maxSum , lSum + rSum);
        }

        return maxSum;
    }
}