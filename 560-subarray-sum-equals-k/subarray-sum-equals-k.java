class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n + 1]; 
        arr[0] = 0;

        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + nums[i - 1];
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
