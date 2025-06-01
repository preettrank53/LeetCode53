class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0 ;
        int j = 0 ;
        int maxLen = 0;

        Map<Character , Integer> map = new HashMap<>();

        while(j<n) {
            if(map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j) , map.get(s.charAt(j))+1);
            }
            else {
                map.put(s.charAt(j) , 1);
            }

            while(map.get(s.charAt(j)) > 1) {
                map.put(s.charAt(i) , map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i))==0) {
                    map.remove(s.charAt(i));
                }
                i++;
            }

            
            maxLen = Math.max(maxLen , j-i+1);
            j++;
            
        }
        return maxLen;
    }
}