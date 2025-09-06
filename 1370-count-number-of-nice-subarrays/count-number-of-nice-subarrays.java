class Solution {

    int atMost(int[] nums , int k) {
        int n = nums.length;

        int i = 0 ;
        int j = 0 ;
        int count = 0;
        int ans = 0;

        while(j < n) {
            if(nums[j] % 2 != 0) {
                count++;
            }

            while(count > k) {
                if(nums[i] % 2 != 0) {
                    count--;
                }
                i++;
            }

            ans = ans + (j-i+1);
            j++;
        }

        return ans;

    }

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}