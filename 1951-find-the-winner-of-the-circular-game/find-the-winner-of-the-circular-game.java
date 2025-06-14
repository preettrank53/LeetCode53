class Solution {

    int helper(int start , int n , int k , List<Integer> list) {

        if(list.size()==1) {
            return list.get(0);
        }

        start = (start + k - 1)%list.size();

        list.remove(start);

        return helper(start , n , k , list );
    }

    public int findTheWinner(int n, int k) {
        
        int start = 0;

        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i<n ; i++)  {
            list.add(i+1);
        }

        return helper(start , n , k , list);

        
    }
}