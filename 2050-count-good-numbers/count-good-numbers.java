class Solution {

    static final long MOD = 1000000007;

    long helper(long a , long b) {
        if(b == 0) {
            return 1;
        }
        if(b < 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return helper((a * a) % MOD, b / 2);
        } else {
            return (a % MOD * helper((a * a) % MOD, (b - 1) / 2)) % MOD;
        }
    }

    public int countGoodNumbers(long n) {
        long part1 = helper(5, (n + 1) / 2);
        long part2 = helper(4, n / 2);

        return (int)((part1 * part2) % MOD);
    }
}