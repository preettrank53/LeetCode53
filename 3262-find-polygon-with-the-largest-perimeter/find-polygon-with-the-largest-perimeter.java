class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        // Try largest perimeter by removing largest values from the end
        for (int i = n - 1; i >= 2; i--) {
            totalSum -= nums[i];
            if (totalSum > nums[i]) {
                return totalSum + nums[i]; // valid polygon found
            }
        }

        return -1; // no valid polygon can be formed
    }
}
