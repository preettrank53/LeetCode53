class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1 && k == 1) {
            return '0';
        }

        // Compute length of Sn using loop: len = 2^n - 1
        int len = 1;
        for (int i = 1; i < n; i++) {
            len = len * 2 + 1;
        }

        int mid = len / 2 + 1;

        if (k == mid) {
            return '1';
        }

        if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            int mirror = len - k + 1;
            char ch = findKthBit(n - 1, mirror);
            return invert(ch);
        }
    }

    private char invert(char c) {
        return c == '0' ? '1' : '0';
    }
}
