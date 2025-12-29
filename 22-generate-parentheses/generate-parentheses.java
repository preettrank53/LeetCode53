class Solution {

    void helper(int open, int close, int n, String str, List<String> list) {
        if (str.length() == 2 * n) {
            list.add(str);
            return;
        }

        if (open < n) {
            helper(open + 1, close, n, str + "(", list);
        }

        if (close < open) {
            helper(open, close + 1, n, str + ")", list);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(0, 0, n, "", list);
        return list;
    }
}
