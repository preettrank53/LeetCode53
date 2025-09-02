class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        
        int j = 0;
        int i = 0;
        int maxLen = 0;

        Map<Integer , Integer> map = new HashMap<>();

        while (j < n) {
            if (map.containsKey(nums[j])) {
                map.put(nums[j], map.get(nums[j]) + 1);
            } else {
                map.put(nums[j], 1);
            }

            while (nums[j] == 0 && map.containsKey(0) && map.get(0) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }
}
