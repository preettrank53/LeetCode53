class Solution {
    public int maximum69Number (int num) {

        List<Integer> list = new ArrayList<>();

        while(num!=0) {
            int x = num % 10;
            list.add(x);
            num = num / 10;
        }

        for(int i = list.size()-1 ; i>=0 ; i--) {
            if(list.get(i)!=9) {
                list.set(i,9);
                break;
            }
        }
        
        int result = 0;
        for(int i = list.size()-1 ; i>=0 ; i--) {
           result = (result*10) + list.get(i);
        }
        return result;
    }
}