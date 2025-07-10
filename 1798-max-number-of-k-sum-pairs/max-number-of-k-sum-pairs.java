class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count=0;

        int l = 0 ; 
        int r = nums.length - 1;

        while(l < r) {
            int sum = nums[l] + nums[r];

            if(sum==k) {
                count++;
                l++;
                r--;
            }
            else if(sum > k) {
                r--;
            }
            else {
                l++;
            }
        }
        return count;
    }
}