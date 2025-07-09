class Solution {
    public int minFlips(int a, int b, int c) {
        int result = ((a|b) ^ c);

        int result1 = (a & b);

        int result2 = (result1 & result);

        int count = 0;

        while(result != 0 ) {
            if((result & 1) == 1 ) {
                count++;
            }
            result >>= 1;
        }

        while(result2 != 0 ) {
            if((result2 & 1) == 1 ) {
                count++;
            }
            result2 >>= 1;
        }

        return count;
    }
}