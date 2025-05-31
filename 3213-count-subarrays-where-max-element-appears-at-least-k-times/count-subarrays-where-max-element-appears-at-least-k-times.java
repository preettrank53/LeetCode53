class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int i = 0 ;
        int j = 0 ; 
        long count = 0 ;

        Map<Integer , Integer> map = new HashMap<>();
        int x = nums[0];
        for (int num : nums) {
            if (num > x) {
                x = num;
            }
        }

        map.put(x , 0);

        while(j<n) {
            if(nums[j]==x) {
                map.put(x , map.get(x)+1);
            }

            while(map.get(x)>=k) {
                count= count + (n-j);  //nums = [1, 3, 3, 3, 2] if i=1 and j=3 so subarray is [3,3]
                                      //3 appears 2 times, which is valid.
                                      //The subarrays [3, 3], [3, 3, 3], [3, 3, 3, 2] are all valid because they include at least 2 3s.
                                      //These subarrays end at indices 2, 3, and 4, and start from index i = 1.
                                      //That’s a total of (n - j) = (5 - 2) = 3 subarrays that start at i and end from j to n-1.
                if(nums[i]==x) {
                    map.put(x , map.get(x)-1);
                }
                i++;
            }

            j++;
        }
        return count;
    }
}