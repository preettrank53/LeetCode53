class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;

        // Base case: prefix sum 0 has occurred once
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Check if there is a prefix sum that leads to a subarray with sum = goal
            if (map.containsKey(sum - goal)) {
                count += map.get(sum - goal);
            }

            // Store/update the frequency of the current prefix sum
            if (map.containsKey(sum)) {
                int x = map.get(sum);
                x++;
                map.put(sum, x);
            } else {
                map.put(sum, 1);
            }
        }

        return count;
    }
}