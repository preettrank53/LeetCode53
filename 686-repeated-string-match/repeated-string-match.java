class Solution {
    public int repeatedStringMatch(String a, String b) {
        // Step 1: Build the KMP LPS (Longest Prefix Suffix) array for pattern `b`
        int[] lps = new int[b.length()];
        int len = 0;
        int i = 1;
        while (i < b.length()) {
            if (b.charAt(i) == b.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int count = 1;
        StringBuilder sb = new StringBuilder(a);
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // Append one more time to handle cases like a="abc", b="cabcabca"
        if (kmpSearch(sb.toString(), b, lps)) return count;
        sb.append(a);
        if (kmpSearch(sb.toString(), b, lps)) return count + 1;

        return -1;
    }

    private boolean kmpSearch(String text, String pattern, int[] lps) {
        int i = 0, j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) return true;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}
