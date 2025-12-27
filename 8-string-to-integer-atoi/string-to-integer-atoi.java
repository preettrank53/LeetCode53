class Solution {

    int helper(String s, int i, int num, int sign) {
        int n = s.length();

        // base case
        if (i == n || !Character.isDigit(s.charAt(i))) {
            return num * sign;
        }

        int digit = s.charAt(i) - '0';

        // overflow check (important, not optional)
        if (num > Integer.MAX_VALUE / 10 ||
           (num == Integer.MAX_VALUE / 10 && digit > 7)) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return helper(s, i + 1, num * 10 + digit, sign);
    }

    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;

        if (i < n) {
            if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (s.charAt(i) == '+') {
                i++;
            }
        }

        return helper(s, i, 0, sign);
    }
}
