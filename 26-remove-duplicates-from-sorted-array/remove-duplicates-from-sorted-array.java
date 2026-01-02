class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        Map<Integer , Integer> map = new LinkedHashMap<>();

        for(int i = 0 ; i<n ; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i] , map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i] , 1);
            }
        }
        int j = 0;
        for(int key : map.keySet()) {
            nums[j] = key;
            j++;
        }

        for(int i = map.size() ; i<n ; i++) {
            nums[i] = -1;
        }

        return map.size();
    }
}