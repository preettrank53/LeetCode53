class Solution {
    public boolean canPlaceFlowers(int[] arr, int m) {
        int n = arr.length;
        if (m == 0) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                continue;
            }

            if (
                (i > 0 && i < n - 1 && arr[i - 1] == 0 && arr[i + 1] == 0) ||
                (i == 0 && (n == 1 || arr[i + 1] == 0)) ||
                (i == n - 1 && arr[i - 1] == 0)
            ) {
                arr[i] = 1;
                m--;

                if (m == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
