class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        int i = 1 ; 
        int j = 0 ;

        while(i < n) {

            if(nums[j] != 0 && j<i) {
                j++;
            }
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            i++;
        }
    }
}