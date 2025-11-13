class Solution {

    int[] findNse(int[] nums) { // Next Smaller Element
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        ans[n - 1] = n;

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = st.peek();
            }

            st.push(i);
        }
        return ans;
    }

    int[] findPse(int[] nums) { // Previous Smaller Element
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        ans[0] = -1;

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            st.push(i);
        }
        return ans;
    }

    int[] findNge(int[] nums) { // Next Greater Element
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        ans[n - 1] = n;

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = st.peek();
            }

            st.push(i);
        }
        return ans;
    }

    int[] findPge(int[] nums) { // Previous Greater Element
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        ans[0] = -1;

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            st.push(i);
        }
        return ans;
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] nse = findNse(nums);
        int[] pse = findPse(nums);
        int[] nge = findNge(nums);
        int[] pge = findPge(nums);

        long sumMax = 0;
        long sumMin = 0;

        for (int i = 0; i < n; i++) {
            long leftMin = i - pse[i];
            long rightMin = nse[i] - i;
            long leftMax = i - pge[i];
            long rightMax = nge[i] - i;

            sumMin += (long) nums[i] * leftMin * rightMin;
            sumMax += (long) nums[i] * leftMax * rightMax;
        }

        return sumMax - sumMin;
    }
}
