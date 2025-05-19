class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        boolean[] arr = new boolean[S.length];

        int n = S.length;
        int m = T.length;

        int i = 0;
        int j = 0;

        while (i < n && j < m) {  
            if (S[i] == T[j]) {
                arr[i] = true;
                i++;
                j++;
            } else {
                j++;
            }
        }

        for (int k = 0; k < n; k++) {
            if (!arr[k]) {
                return false;
            }
        }

        return true;
    }
}
