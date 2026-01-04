class Solution {
    static final int MOD = 1000000007;

    long pow(long n, int length) {
        if (length == 0) {
            return 1;
        }

        if (length % 2 == 0) {
            return pow((n * n) % MOD, length / 2);
        } else {
            return (n * pow((n * n) % MOD, (length - 1) / 2)) % MOD;
        }
    }


    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        long count = 0;

        int left = 0;
        int right = n-1;

        while(left <= right) {
            int sum = nums[left] + nums[right];
            if(sum > target) {
                right--;
            }
            else {
                int length = right - left;
                count = (count + pow(2 , length)) % MOD;
                left++;
            }
        }
        return (int)count;
    }
}