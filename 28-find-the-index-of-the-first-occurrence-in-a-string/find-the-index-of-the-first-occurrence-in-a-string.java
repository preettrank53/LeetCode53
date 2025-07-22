class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        int[] LPS = new int[m];
        int len = 0;
        int I = 1;

        LPS[0] = 0;

        while(I < m) {
            if(needle.charAt(I) == needle.charAt(len)) {
                len++;
                LPS[I] = len;
                I++;
            }
            else {
                if(len != 0 ) {
                    len = LPS[len-1];
                }
                else {
                    LPS[I] = 0;
                    I++;
                }
            }
        }

        int i = 0 ;
        int j = 0 ;

        while(i < n) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if(j == m) {
                    return i-j;
                }
            }
            else {
                if(j != 0) {
                    j = LPS[j-1];
                }
                else {
                    i++;
                }

            }

        }
            return -1;

    }
}