class Solution {
    public boolean halvesAreAlike(String s) {
        int vowel1 = 0;
        int vowel2 = 0;

        char[] ch = s.toCharArray();
        int j = s.length() / 2;

        for (int i = 0; i < s.length() / 2; i++) {
            if (isVowel(ch[i])) vowel1++;
            if (isVowel(ch[j])) vowel2++;
            j++;
        }

        return vowel1 == vowel2;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
