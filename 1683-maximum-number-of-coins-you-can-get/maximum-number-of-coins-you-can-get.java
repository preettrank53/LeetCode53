class Solution {
    public int maxCoins(int[] piles) {
        // this is 2nd approache

        Arrays.sort(piles);
        int n = piles.length;

        int m = n/3;
        int result = 0;

        for(int i = m ; i<n ; i+=2) {
            result = result + piles[i];
        }

        return result;

    }
}