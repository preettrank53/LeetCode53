class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        // Count the frequency of each element
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>(map.keySet());

        for (int i = 0; i < map.size(); i++) {
            int key = list.get(i);
            int freq = map.get(key);

            if (freq == 1) {
                return -1;
            }

            while (freq > 0) {
                if (freq == 2 || freq % 3 == 1) {
                    freq -= 2;
                    count++;
                } else {
                    freq -= 3;
                    count++;
                }
            }
        }

        return count;
    }
}
