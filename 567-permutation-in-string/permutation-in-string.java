class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int m = s1.length();

        Map<Character , Integer> map = new HashMap<>();

        for(int i = 0 ; i < m ; i++ ) {
            char ch = s1.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch , map.get(ch) + 1);
            }
            else {
                map.put(ch , 1);
            }
        }

        int i = 0 ;
        int j = 0 ;
        int count = map.size();
        
        while(j < n) {
            char ch = s2.charAt(j);
            if(map.containsKey(ch)) {
                map.put(ch , map.get(ch) - 1);
                if(map.get(ch) == 0) {
                    count--;
                }
            }

            while(j-i+1 > m) {
                char ch1 = s2.charAt(i);
                if(map.containsKey(ch1)) {
                    if(map.get(ch1) == 0 ) {
                        count++;
                    }
                    map.put(ch1 , map.get(ch1) + 1);
                }
                i++;
            }

            if(count == 0 && (j-i+1) == m) {
                return true;
            }
            j++;
        }
        return false;
    }
}