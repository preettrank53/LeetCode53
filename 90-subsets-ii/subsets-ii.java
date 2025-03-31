class Solution {

    void printSubSet(Set<List<Integer>> set , List<Integer> arr , List<Integer> ans , int i ) {
        if(i==arr.size()) {

            set.add(new ArrayList<>(ans));
            
            return;
        }

        //include

        ans.add(arr.get(i));
        printSubSet(set,arr,ans,i+1);

        // Backtrack (remove last element)
        ans.remove(ans.size()-1);

        //exclude
        printSubSet(set,arr,ans,i+1);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();
        List<Integer> arr = new ArrayList<>();

        Arrays.sort(nums);  // draw recursion tree for [1,2,2] & [2,1,1] , than see the difference
        
        // Convert int[] to List<Integer>
        for(int i = 0 ; i <nums.length ; i++) {
            arr.add(nums[i]);
        } 

        List<Integer> ans = new ArrayList<>();

        printSubSet(set , arr , ans , 0);
        return new ArrayList<>(set);

    }
}