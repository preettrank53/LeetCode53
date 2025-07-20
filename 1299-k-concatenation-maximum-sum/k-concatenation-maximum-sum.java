class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        long total = 0;
        for (int num : arr) {
            total += num;
        }

        int maxSum = 0;
        int curr = 0;

        for (int i = 0; i < n * Math.min(k, 2); i++) {
            int index = i % n;
            curr = curr + arr[index];

            if (curr > maxSum) {
                maxSum = curr;
            }

            if (curr < 0) {
                curr = 0;
            }
        }

        long result = maxSum;
        if (k > 2 && total > 0) {
            result = (result + (k - 2) * total);
        }

        return (int)(result % MOD);
    }
}
