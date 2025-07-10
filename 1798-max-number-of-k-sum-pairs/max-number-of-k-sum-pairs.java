class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int x = k - nums[i];

            if (map.containsKey(x) && map.get(x) > 0) {
                count++;
                map.put(x, map.get(x) - 1);
            } else {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }
        }

        return count;
    }
}
