class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int l = 1;
        int r = 0;

        while (r < n) {
            if (l < arr[r]) {
                k--;
                if (k == 0) return l;
                l++;
            } else if (l == arr[r]) {
                r++;
                l++;
            }
        }

        // Still missing numbers left after array
        return l + k - 1;
    }
}
