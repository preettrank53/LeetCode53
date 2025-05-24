class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int i = 0;
        int j = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(target, Integer.MAX_VALUE); // initialize with large value

        while (j < n) {
            sum = sum + nums[j];

            while (sum >= target) {
                if (map.get(target) > j - i + 1) {
                    map.put(target, j - i + 1);
                }
                sum = sum - nums[i];
                i++;
            }

            j++;
        }

        if (map.get(target) == Integer.MAX_VALUE) {
            return 0;
        }

        return map.get(target);
    }
}
