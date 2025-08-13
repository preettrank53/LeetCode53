class NumArray {
    private int[] tree;
    private int n;

    public NumArray(int[] nums) {
        if (nums.length == 0) return;
        n = nums.length;
        tree = new int[4 * n];
        build(nums, 0, n - 1, 0);
    }

    private void build(int[] nums, int start, int end, int node) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(nums, start, mid, 2 * node + 1);
        build(nums, mid + 1, end, 2 * node + 2);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public void update(int index, int val) {
        update(0, n - 1, 0, index, val);
    }

    private void update(int start, int end, int node, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(start, mid, 2 * node + 1, idx, val);
        } else {
            update(mid + 1, end, 2 * node + 2, idx, val);
        }
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public int sumRange(int left, int right) {
        return query(0, n - 1, 0, left, right);
    }

    private int query(int start, int end, int node, int left, int right) {
        if (right < start || left > end) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        int leftSum = query(start, mid, 2 * node + 1, left, right);
        int rightSum = query(mid + 1, end, 2 * node + 2, left, right);
        return leftSum + rightSum;
    }
}
