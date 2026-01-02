class Solution {
    public int help(int[] nums , int t , int s , int e) {
        if (s > e) {
            return -1;
        }

        int m = (s + e)/2;

        if (nums[m]==t) {
            return m;
        }
        if (t < nums[m]) {
            return help(nums , t, s , m-1);
        }
        
            return help(nums , t, m+1 , e);
       
    }
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        int t = target;
        return help(nums , t , s , e);
        
    }
}