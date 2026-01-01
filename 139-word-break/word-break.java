class Solution {

    Boolean[] memo;

    boolean helper(int n, String s, List<String> wordDict) {

        if (n == s.length()) {
            return true;
        }

        if (memo[n] != null) {
            return memo[n];
        }

        for (int i = n + 1; i <= s.length(); i++) {
            String temp = s.substring(n, i);

            if (wordDict.contains(temp) && helper(i, s, wordDict)) {
                memo[n] = true;
                return true;
            }
        }

        memo[n] = false;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        return helper(0, s, wordDict);
    }
}
