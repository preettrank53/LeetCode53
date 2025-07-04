class Solution {
    public int kthGrammar(int n, int k) {
        
        // Base case
        if(n==1 && k==1) {
            return 0;
        }

        int len = (int)Math.pow(2,n-1);
        int mid = len / 2 ;

        if(k<=mid) {
            return kthGrammar(n-1 , k);
        }
        else {
            return 1-kthGrammar(n-1 , k-mid);  // 1-  because if ans 0 tha 1-0 = 1 and ans is 1 than 1-1=0
        }
    }
}