class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();

        int i = 0 ;
        int j = 0 ;
        int count = 0 ;
        int maxCount = 0 ;

        while(j < n) {
            if(s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o' || s.charAt(j) == 'u') {
                count++;
            }

            while(j - i + 1 == k) {
                maxCount = Math.max(maxCount , count);
                if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                    count--;
                }
                i++;
            }

            j++;
        }

        return maxCount;
    }
}