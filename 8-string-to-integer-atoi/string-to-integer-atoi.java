class Solution {

    boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public int myAtoi(String s) {
        int n = s.length();

        int num = 0 ;
        int sign = 1;
        int i = 0 ;

        // 1. Whitespace
        while(i < n && s.charAt(i) == ' ') {
            i = i + 1;
        }

        // 2 . Signedness
        if(i < n) {
            if(s.charAt(i) == '-') {
                i = i + 1;
                sign = -1;
            }
            else if(s.charAt(i) == '+') {
                i = i + 1;
            }
        }

        // 3 . Conversion
        while(i < n && isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4.Rounding
            if(num == Integer.MAX_VALUE / 10) {
                if(sign == 1) {
                    if(digit >= 7) {
                        return Integer.MAX_VALUE;
                    }
                }
                else {
                    if(digit >= 8) {
                        return Integer.MIN_VALUE;
                    }
                }
            }

            if(num > Integer.MAX_VALUE / 10) {
                if(sign == 1) {
                    return Integer.MAX_VALUE;
                }
                else {
                    return Integer.MIN_VALUE;
                }
            }
            num = num * 10 + digit;
            i = i + 1;
        }

        return num * sign;
    }
}