class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        arr[0] = 1;  // Set the first element to 1 as required

        for (int i = 1; i < n; i++) {
            // Make sure each element is at most 1 greater than the previous one
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }

        // After rearranging, the last element is the maximum
        return arr[n - 1];
    }
}
