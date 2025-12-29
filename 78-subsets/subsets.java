class Solution {

    void helper(int[] nums, List<List<Integer>> list, List<Integer> arr, int n) {
        if (n == nums.length) {
            list.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[n]);
        helper(nums, list, arr, n + 1);

        arr.remove(arr.size() - 1);
        helper(nums, list, arr, n + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        helper(nums, list, arr, 0); 
        return list;
    }
}
