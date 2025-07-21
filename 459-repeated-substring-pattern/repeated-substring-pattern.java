class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n <= 1) {
            return false;
        }

        for (int len = 1; len <= n / 2; len++) {
            if (n % len != 0) continue;

            String str = s.substring(0, len);
            int i = 0;
            while (i + len <= n) {
                String temp = s.substring(i, i + len);
                if (!temp.equals(str)) {
                    break;
                }
                i += len;
            }

            if (i == n) {
                return true;
            }
        }

        return false;
    }
}
