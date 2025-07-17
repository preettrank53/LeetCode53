class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int count = 0 ;

        for(int i = 0 ; i<m ; i++) {
            for(int j = 1 ; j<n ; j++) {
                String s1 = strs[j-1];
                String s2 = strs[j];
                if(s1.charAt(i) > s2.charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}