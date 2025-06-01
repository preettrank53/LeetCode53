class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++) {
            int x1 = s.charAt(i); 
            int x2 = t.charAt(i);
            arr[i] = Math.abs(x1 - x2) ; 
        }

        int i = 0 ;
        int j = 0 ;
        int sum = 0;
        int maxLen = 0;

        while(j < n) {
            sum = sum + arr[j];

            while(sum > maxCost) {
                sum = sum - arr[i];
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }
}
