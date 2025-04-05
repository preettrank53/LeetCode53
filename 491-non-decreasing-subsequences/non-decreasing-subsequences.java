class Solution {

    void solve(Set<List<Integer>> result , int[] nums , int prev , int i , List<Integer> combi ) {

        //base condition
        if(i==nums.length) {
            if(combi.size()>=2) {
                result.add(new ArrayList(combi));
            }
            return;
        }

        if(nums[i]>=prev) {
            combi.add(nums[i]);
            solve(result , nums , nums[i] , i+1 ,combi);

            // backtrack
            combi.remove(combi.size()-1);
        }

        // its also part of backtrack
        solve(result , nums , prev , i+1 , combi);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> combi = new ArrayList<>();

        solve(result, nums , -101 , 0 , combi);

        return new ArrayList(result);
    }
}