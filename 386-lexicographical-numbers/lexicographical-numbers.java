class Solution {

    void helper(int i , int n , List<Integer> list) {
        if(i>n) {
            return;
        }

        list.add(i);

        for(int j = 0 ; j<=9 ; j++) {
            int newDigit = i*10 + j ;

            if(newDigit > n) {
                return;
            }
            helper(newDigit , n , list );
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();

        for(int i = 1 ; i <= 9 ; i++) {
            helper(i , n , list);
        }
        return list;
    }
}