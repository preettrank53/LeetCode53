// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n==1) {
//             return nums[0];
//         }

//         if(n==2) {
//             return Math.max(nums[0] , nums[1]);
//         }

//         int[] m = new int[n];
//         m[0] = nums[0];
//         m[1] = Math.max(nums[1] , m[0] );

//         int[] t = new int[n];
//         t[0] = m[0];
//         t[1] = m[1];

//         for(int i = 2 ; i<n ; i++) {
//             m[i] = Math.max(nums[i] , m[i-1]);
//         }

//         for(int i = 2 ; i<n ; i++) {
//             t[i] = nums[i] + m[i-2];
//             m[i] = Math.max(t[i] , m[i]);
//         }

//         return Math.max(m[n-1] , m[n-2]);
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] m = new int[n];
        int[] t = new int[n];

        m[0] = nums[0];
        m[1] = Math.max(nums[0], nums[1]);

        t[0] = nums[0]; // technically not needed, but matching your pattern
        t[1] = nums[1]; // again optional, not used in final result

        for (int i = 2; i < n; i++) {
            t[i] = nums[i] + m[i - 2];
            m[i] = Math.max(m[i - 1], t[i]);
        }

        return m[n - 1];
    }
}
