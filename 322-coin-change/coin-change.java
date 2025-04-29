class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] t = new int[amount + 1];
        int n = coins.length;

        // Initialize all values with a large number (representing infinity)
        for (int i = 0; i <= amount; i++) {
            t[i] = amount + 1;
        }

        t[0] = 0; // Base case: 0 coins to make amount 0

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                int coin = coins[j];
                if (coin <= i) {
                    t[i] = Math.min(t[i], t[i - coin] + 1);
                }
            }
        }

        if (t[amount] > amount) {
            return -1;
        } else {
            return t[amount];
        }
    }
}
