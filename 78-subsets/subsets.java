class Solution {

    void printSubSet(List<List<Integer>> list , List<Integer> arr , List<Integer> ans , int i ) {
        if(i==arr.size()) {
            list.add(new ArrayList<>(ans));
            return;
        }

        //include

        ans.add(arr.get(i));
        printSubSet(list,arr,ans,i+1);

        // Backtrack (remove last element)
        ans.remove(ans.size()-1);

        //exclude
        printSubSet(list,arr,ans,i+1);

    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        
        // Convert int[] to List<Integer>
        for(int i = 0 ; i <nums.length ; i++) {
            arr.add(nums[i]);
        } 

        List<Integer> ans = new ArrayList<>();

        printSubSet(list , arr , ans , 0);
        return list;

    }
}