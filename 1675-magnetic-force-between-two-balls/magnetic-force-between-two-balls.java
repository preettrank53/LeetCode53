class Solution {
    boolean helper(int[] position, int mid, int m) {
        int count = 1;
        int lastPos = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= mid) {
                count++;
                lastPos = position[i];
                if (count == m) return true;
            }
        }

        return false;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position); // O(n log n)

        int l = 1;
        int r = position[position.length - 1] - position[0];
        int ans = 0;

        while (l <= r) { // Binary search loop = O(log(max distance))
            int mid = l + (r - l) / 2;

            if (helper(position, mid, m)) { // helper = O(n)
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}
