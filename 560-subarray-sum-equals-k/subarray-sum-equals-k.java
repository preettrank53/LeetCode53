class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        
        freq.put(0, 1);
        int sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (freq.containsKey(sum - k)) {
                count += freq.get(sum - k);
            }

            if (freq.containsKey(sum)) {
                freq.put(sum, freq.get(sum) + 1);
            } else {
                freq.put(sum, 1);
            }
        }

        return count;
    }
}
