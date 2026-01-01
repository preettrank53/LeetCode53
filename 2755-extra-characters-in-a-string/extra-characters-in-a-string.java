class Solution {

    Integer[] memo;

    int helper(String s, List<String> list, int n) {
        if (n == s.length()) {
            return 0;
        }

        if (memo[n] != null) {
            return memo[n];
        }

        //treat current char as extra
        int min = 1 + helper(s, list, n + 1);

        //match dictionary words
        for (int i = n + 1; i <= s.length(); i++) {
            String temp = s.substring(n, i);
            if (list.contains(temp)) {
                min = Math.min(min, helper(s, list, i));
            }
        }

        memo[n] = min;
        return min;
    }

    public int minExtraChar(String s, String[] dictionary) {
        List<String> list = new ArrayList<>();
        for (String word : dictionary) {
            list.add(word);
        }

        memo = new Integer[s.length()];
        return helper(s, list, 0);
    }
}
