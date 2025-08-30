import java.util.*;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            int rem = ((sum % k) + k) % k;

            if (freq.containsKey(rem)) {
                count += freq.get(rem);
                freq.put(rem, freq.get(rem) + 1); 
            } else {
                freq.put(rem, 1);  
            }
        }

        return count;
    }
}
