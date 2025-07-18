class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] freq = new int[26];
        int count = 0;

        for(int i = 0 ; i<allowed.length() ; i++) {
            freq[allowed.charAt(i) - 'a'] = 1;
        }

        for(int i = 0 ; i < words.length ; i++) {
            boolean result = true;
            for(int j = 0 ; j< words[i].length() ; j++) {
                if(freq[words[i].charAt(j) - 'a'] == 0) {
                    result = false;
                    break;
                }
                
            }
            if(result==true) {
                count++;
            }
        }
        return count;

    }
}