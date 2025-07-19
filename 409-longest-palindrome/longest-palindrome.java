class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        int oneCount = 0;
        int count = 0;

        for (char ch : map.keySet()) { 
            int freq = map.get(ch);

            if (freq % 2 == 0) {
                count = count + freq; 
            } else {
                count = count + freq - 1; // Use (odd - 1) to keep it even
                oneCount = 1; // Mark that we can add 1 odd character in the center
            }
        }

        return count + oneCount; // Add center character if any odd found
    }
}
