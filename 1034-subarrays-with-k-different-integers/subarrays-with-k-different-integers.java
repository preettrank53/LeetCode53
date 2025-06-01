class Solution {

    int helper(Map<Integer , Integer> map , int[] nums , int k) {
        int n = nums.length;
        int i = 0 ;
        int j = 0 ; 

        int count = 0;
        int diffInt = 0;

        while(j < n) {
            if (map.containsKey(nums[j])) {
                map.put(nums[j], map.get(nums[j]) + 1);
            } else {
                map.put(nums[j], 1);
                diffInt++;
            }

            while (diffInt > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                    diffInt--;
                }
                i++;
            }

            count = count + (j - i + 1);
            j++;
        } 
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer , Integer> map1 = new HashMap<>();
        Map<Integer , Integer> map2 = new HashMap<>();

        int atMostK = helper(map1 , nums , k);
        int atMostKMinus1 = helper(map2 , nums , k - 1);

        return atMostK - atMostKMinus1;
    }
}
