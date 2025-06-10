class Solution {
    public int maxCoins(int[] piles) {

        Arrays.sort(piles);
        
        int n = piles.length;

        int A = n-1 , B = 0 , Y = n-2 ;
        int result = 0 ; 

        while(Y > B) {
            result = result + piles[Y];
            B++;
            Y = Y - 2;
        }
        return result;
    }
}