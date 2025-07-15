class Solution {

    void countAndSay(StringBuilder str, StringBuilder result) {
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result.append(count);
                result.append(str.charAt(i - 1));
                count = 1;
            }
        }

        // Append the last group
        result.append(count);
        result.append(str.charAt(str.length() - 1));
    }

    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder("1");

        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            countAndSay(s, next);
            s = next;  // prepare for next iteration
        }

        return s.toString();
    }
}
