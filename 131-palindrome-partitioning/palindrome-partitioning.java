class Solution {

    boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    void helper(String s, List<List<String>> list, List<String> ans, int n) {

        if (n == s.length()) {
            list.add(new ArrayList<>(ans));
            return;
        }

        String str = "";
        for (int i = n; i < s.length(); i++) {
            str += s.charAt(i);

            if (isPalindrome(str)) {
                ans.add(str);
                helper(s, list, ans, i + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        helper(s, list, new ArrayList<>(), 0);
        return list;
    }
}
