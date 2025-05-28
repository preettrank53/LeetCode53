class Solution {
    public int longestSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);

        int i = 0;
        int j = 0;
        int maxOne = 0;

        while (j < nums.length) {
            map.put(nums[j], map.get(nums[j]) + 1);

            // If we have more than one zero, move left pointer
            while (map.get(0) > 1) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }

            // Only update if we have deleted one element (i.e., allowed one zero)
            maxOne = Math.max(maxOne, j - i);
            j++;
        }

        return maxOne;
    }
}
