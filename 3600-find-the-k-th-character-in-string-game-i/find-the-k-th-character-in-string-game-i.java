class Solution {
    public char kthCharacter(int k) {
        if(k==1) {
            return 'a';
        }

        int len = 1;
        while(len < k) {
            len = len * 2 ;
        }

        int mid = len / 2;
        if(k<=mid) {
            return kthCharacter(k);
        }

        else {
            char ch = kthCharacter(k-len/2);
            if(ch=='z') {
                return 'a';
            }

            return (char)(ch+1);
        }


    }
}