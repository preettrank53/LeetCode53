class Solution {

    int rev(int n) {
        int reverse = 0;
        while(n!=0) {
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n = n / 10;
        }

        return reverse;
    }

    public int countNicePairs(int[] nums) {
        int[] revArr = new int[nums.length];
        int mod = 1_000_00_0007;
        for(int i = 0 ; i < nums.length ; i++) {
            revArr[i] = rev(nums[i]);
        }

        for(int i = 0 ; i < nums.length ; i++) {
            nums[i] = nums[i] - revArr[i];
        }

        Map<Integer , Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(map.containsKey(nums[i])) {
                int n = map.get(nums[i]);
                count = ( count + n ) % mod;
                n++;
                map.put(nums[i] , n);
            }
            else {
                map.put(nums[i] , 1);
            }
        }

        return count;
    }
}