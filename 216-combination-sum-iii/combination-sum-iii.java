class Solution {

    void helper(int k , int n , List<List<Integer>> list , List<Integer> ans , int start) {
        if(n == 0 && ans.size() == k) {
            list.add(new ArrayList<>(ans));
            return;
        }

        if(ans.size() == k || n < 0) {
            return;
        }

        for(int i = start ; i<10 ; i++) {
            if(n - i < 0) {
                break;
            }

            ans.add(i);
            helper(k , n - i , list , ans , i + 1 );
            ans.remove(ans.size() - 1);
        }
    }


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(k , n , list , new ArrayList<>() , 1);

        return list;
    }
}