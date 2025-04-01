class Solution {

    void backTrack(List<List<Integer>> result , List<Integer> ans , int[] nums ) {

        // If we match the length , it is a permutation

        if(ans.size()==nums.length) {
            result.add(new ArrayList(ans));
            return;
        }

        for(int number : nums) {
            // skip if we get same element
            if(ans.contains(number)) {
                continue;
            }

            // Add the new element
            ans.add(number);

            // Go back to try other element
            backTrack(result , ans , nums);

            // Remove the element
            ans.remove(ans.size()-1);

        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        backTrack(result , ans , nums);

        return result;        

    }
}