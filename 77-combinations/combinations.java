class Solution {

    void combinations(int[] arr , int i , Set<List<Integer>> ans , List<Integer> combin , int k) {

        // Base Case

        if(k==0) {
            ans.add(new ArrayList<>(combin));
            return;
        }

        if (i == arr.length) {
        return;
        }


        combin.add(arr[i]);
        // call for include elements
        combinations(arr , i+1 , ans , combin , k-1);

        // before Backtracking
        combin.remove(combin.size()-1);

        // call for exclude elements
        combinations(arr , i+1 , ans ,combin , k);
    }

    public List<List<Integer>> combine(int n, int k) {

        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> combin = new ArrayList<>();

        int arr[] = new int[n];
        for(int i = 0 ; i<n ; i++) {
            arr[i]=i+1;
        }

        combinations(arr, 0 , ans , combin , k);
        return new ArrayList<>(ans);


    }
}