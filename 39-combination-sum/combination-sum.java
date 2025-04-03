class Solution {

    void combSum(int[] arr ,int i , int target , Set<List<Integer>> ans , List<Integer> combin ) {

        // Base case

        if(target==0) {
            ans.add(new ArrayList<>(combin));
            return;
        }

        if(i==arr.length || target<0) {
            return;
        }


        combin.add(arr[i]);
        // call for single choise
        combSum(arr , i+1 , target-arr[i] , ans , combin);

        // call for multiple choise
        combSum( arr , i , target-arr[i] , ans , combin);

        // Before BackTracking remove last element from combination
        combin.remove(combin.size()-1);
        
        //call for exclude choise
        combSum( arr , i+1 , target , ans , combin );
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> combin = new ArrayList<>();       //combin==combination

        combSum(arr, 0 , target , ans , combin);
        return new ArrayList<>(ans);
    }
}