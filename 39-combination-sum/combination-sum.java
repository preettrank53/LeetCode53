class Solution {

    int sum = 0 ;
    void helper(int[] candidates , int target , List<List<Integer>> list , List<Integer> ans , int sum , int n) {
 
        if (sum == target) {
            list.add(new ArrayList<>(ans));
            return;
        }

        if (sum > target || n >= candidates.length) {
            return;
        }

        ans.add(candidates[n]);
        helper(candidates, target, list, ans, sum + candidates[n], n);
        ans.remove(ans.size() - 1); 

        helper(candidates, target, list, ans, sum, n + 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        helper(candidates, target, list, new ArrayList<>(), 0, 0);
        return list;
    }
}