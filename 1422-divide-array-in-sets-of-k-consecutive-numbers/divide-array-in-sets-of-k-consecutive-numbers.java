class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
    int x = nums.length % k;
        if(x!=0) {
            return false;
        }

        TreeMap<Integer , Integer> map = new TreeMap<>();
        for(int i = 0 ; i<nums.length ; i++) {
            if(map.containsKey(nums[i])) {
                int n = map.get(nums[i]);
                n++;
                map.put(nums[i] , n);
            }
            else {
                map.put(nums[i] , 1);
            }
        }

        while(!map.isEmpty()) {
            int curr = map.firstKey();

            for(int i = 0 ; i < k ; i++) {
                if(!map.containsKey(curr+i)) {
                    return false;
                }

                map.put(curr+i , map.get(curr+i) - 1);
                if(map.get(curr+i)==0) {
                    map.remove(curr+i);
                }
            }
        }

        return true;
    }
}