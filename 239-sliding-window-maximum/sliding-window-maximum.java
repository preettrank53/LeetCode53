class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int idx = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0 ; i<n ; i++) {

            while(!dq.isEmpty() && dq.getFirst() <= i-k) {
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }

            dq.add(i);

            if(i >= k-1) {
                ans[idx] = nums[dq.getFirst()];
                idx++;
            }
        }

        return ans;
    }
}