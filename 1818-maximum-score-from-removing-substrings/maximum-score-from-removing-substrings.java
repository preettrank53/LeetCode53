class Solution {
    public int maximumGain(String s, int x, int y) {
        int baScore = 0;
        int abScore = 0;
        int n = s.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            sb.append(ch);
        }

        // \U0001f525 Key fix: Use '>' instead of '>=' to explore better gain order
        if (x <= y) {
            // Remove "ba" first
            int i = 0;
            while (i < sb.length() - 1) {
                if (sb.charAt(i) == 'b' && sb.charAt(i + 1) == 'a') {
                    baScore += y;
                    sb.delete(i, i + 2);
                    if (i > 0) i--;
                } else {
                    i++;
                }
            }

            // Then remove "ab"
            i = 0;
            while (i < sb.length() - 1) {
                if (sb.charAt(i) == 'a' && sb.charAt(i + 1) == 'b') {
                    abScore += x;
                    sb.delete(i, i + 2);
                    if (i > 0) i--;
                } else {
                    i++;
                }
            }
        } else {
            // Remove "ab" first
            int i = 0;
            while (i < sb.length() - 1) {
                if (sb.charAt(i) == 'a' && sb.charAt(i + 1) == 'b') {
                    abScore += x;
                    sb.delete(i, i + 2);
                    if (i > 0) i--;
                } else {
                    i++;
                }
            }

            // Then remove "ba"
            i = 0;
            while (i < sb.length() - 1) {
                if (sb.charAt(i) == 'b' && sb.charAt(i + 1) == 'a') {
                    baScore += y;
                    sb.delete(i, i + 2);
                    if (i > 0) i--;
                } else {
                    i++;
                }
            }
        }

        return baScore + abScore;
    }
}
