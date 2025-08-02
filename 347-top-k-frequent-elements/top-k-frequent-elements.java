class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer , Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0 ; i < n ; i++) {
            if(map.containsKey(nums[i])) {
                int x = map.get(nums[i]);
                x++;
                map.put(nums[i] , x);
            } 
            else {
                map.put(nums[i] , 1);
            }
        }

        int[] ans = new int[k];

        for(int i = 0 ; i < k ; i++) {
            int max = 0;
            int key = 0;

            for(int ele : map.keySet()) {
                if(map.get(ele) > max) {
                    max = map.get(ele);
                    key = ele;
                }
            }

            ans[i] = key;
            map.remove(key);
        }

        return ans;
    }
}
