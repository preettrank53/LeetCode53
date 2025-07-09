class Solution {
    public int[] sortByBits(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int bit1 = counts(arr[i]), bit2 = counts(arr[j]);
                if ((bit1 > bit2) || (bit1 == bit2 && arr[i] > arr[j])) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int counts(int n) {
        int c = 0;
        while (n > 0) {
            c += (n & 1);
            n >>= 1;
        }
        return c;
    }
}