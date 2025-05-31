class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < nums.length; j++) {
            if (map.containsKey(nums[j])) {
                map.put(nums[j], map.get(nums[j]) + 1);
            } else {
                map.put(nums[j], 1);
            }


            // Shrink window if any element's count > k
            while (map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}
