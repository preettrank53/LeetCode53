class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();

        if(n <= 1) {
            return s;
        }

        String result = s.substring(0,1);  // Initialize with first character

        for(int i = 1 ; i < n ; i++) {
            int l = i;
            int r = i;

            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                String palindrom = s.substring(l, r + 1);
                if(palindrom.length() > result.length()) {
                    result = palindrom;
                }
                l--;
                r++;
            }

            l = i-1;
            r = i;

            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                String palindrom = s.substring(l, r + 1);
                if(palindrom.length() > result.length()) {
                    result = palindrom;
                }
                l--;
                r++;
            }
        }

        return result;
    }
}
