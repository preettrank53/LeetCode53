class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();

        if (n == 1) return "";  // Cannot make a 1-letter palindrome non-palindromic

        char[] ch = palindrome.toCharArray();

        // Change the first non-'a' character in the first half to 'a'
        for (int i = 0; i < n / 2; i++) {
            if (ch[i] != 'a') {
                ch[i] = 'a';
                return new String(ch);
            }
        }

        // If all characters in the first half are 'a', change the last character to 'b'
        ch[n - 1] = 'b';
        return new String(ch);
    }
}
