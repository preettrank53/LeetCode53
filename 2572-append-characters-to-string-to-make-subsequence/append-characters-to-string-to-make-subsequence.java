class Solution {
    public int appendCharacters(String s, String t) {
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        boolean[] arr = new boolean[T.length];

        int n = S.length;
        int m = T.length;

        int i = 0;
        int j = 0;  

        while (i < n && j < m) {  
            if (S[i] == T[j]) {
                arr[j] = true;
                i++;
                j++;
            } else {
                i++;
            }
        }

        int count = 0;
        for(int k = 0 ; k< m ; k++) {
            if(arr[k]==false) {
                count++;
            }
        }

        return count; 
    }
}