class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;

        for(int i = 1 ; i <= n ; i++) {
            int count = 0 ;
            int temp = i;

            while( temp != 0 ) {
                if((temp & 1) == 1 ) {
                    count++;
                }
                temp >>= 1;
            }

            ans[i] = count;

        }
        return ans;
    }
}