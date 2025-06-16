class Solution {
    public char kthCharacter(long k, int[] operations) {
        if(k==1) {
            return 'a';
        }

        int n = operations.length;
        int opType = 0;
        long len = 1 ; 
        long newK = k ;

        for(int i = 0 ; i<n ; i++) {
            len = len * 2;
            if(len>=k) {
                opType = operations[i];
                newK = k - len/2;
                break;
            }
        }

        char res = kthCharacter(newK , operations) ;

        if(opType==0) {
            return res;
        }

        if(res=='z') {
            return 'a';
        }

        return (char)(res+1);
    }
}