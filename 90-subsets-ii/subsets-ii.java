class Solution {

    void helper(int[] nums , List<List<Integer>> list  , List<Integer> ans, int n) {
        if(n == nums.length) {
            list.add(new ArrayList<>(ans));
            return;
        }

        ans.add(nums[n]);
        helper(nums , list , ans , n+1);
        ans.remove(ans.size() - 1);

        while(n + 1 < nums.length && nums[n] == nums[n+1]) {
            n++;
        }
        helper(nums , list , ans , n+1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        helper(nums , list , new ArrayList<>() , 0);

        return list;
    }
}