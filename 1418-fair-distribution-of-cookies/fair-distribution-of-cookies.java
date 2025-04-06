class Solution {

    int minUnfair = Integer.MAX_VALUE;
    void result(int[] cookies , int[] child , int idx , int k) {

        // base case
        if(idx==cookies.length) {

            int max = 0;
            for (int i = 0; i < child.length; i++) {
                max = Math.max(max, child[i]);
            }

            minUnfair = Math.min(minUnfair , max);        
            return;    

        }
        

        for(int i = 0 ; i<k ; i++) {
            child[i] = child[i] + cookies[idx];

            // explore
            result(cookies , child , idx+1 , k);

            //backtrack
            child[i] = child[i] - cookies[idx];

            if(child[i]==0) {
                break;
            }
        }
    }

    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int[] child = new int[k];

        result(cookies , child , 0 , k);
        return minUnfair;
    }
}