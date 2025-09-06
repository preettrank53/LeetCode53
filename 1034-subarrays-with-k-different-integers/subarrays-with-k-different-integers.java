class Solution {

    int atMost(int[] nums , int k) {
        int n = nums.length;

        int i = 0 ;
        int j = 0;
        int count = 0;
        int ans = 0;

        Map<Integer , Integer> map = new HashMap<>();

        while(j < n) {

            if(map.containsKey(nums[j])) {
                map.put(nums[j] , map.get(nums[j]) + 1);
            }
            else {
                map.put(nums[j] , 1);
            }

            while(map.size() > k) {
                map.put(nums[i] , map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            ans = ans + (j-i+1);
            j++;
        }

        return ans;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums , k) - atMost(nums , k-1);
    }
}