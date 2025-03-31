class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];
        int m = nums.length;
        int n = ans.length;
        int index = 0;

        for (int i = 0 ; i < ans.length ; i++) {
            if(i<n/2) {
                ans[i]=nums[i];
            }

            if(m<=i) {
                ans[i] = nums[i-m];
            }
        }

        return ans;
    }
}