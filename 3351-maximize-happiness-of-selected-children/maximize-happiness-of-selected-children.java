import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        // Sort once in descending order
        Arrays.sort(happiness);
        int n = happiness.length;

        long ans = 0;

        // Traverse from largest to smallest
        for (int i = 0; i < k; i++) {
            int index = n - 1 - i; // get highest remaining
            int happy = happiness[index] - i;
            if (happy > 0) {
                ans += happy;
            } else {
                break; // no point in adding 0 or negative happiness
            }
        }

        return ans;
    }
}
