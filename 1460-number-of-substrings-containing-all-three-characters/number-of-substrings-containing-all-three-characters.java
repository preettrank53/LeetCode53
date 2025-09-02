class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();

        Map<Character , Integer> map = new HashMap<>();
        map.put('a' , 0);
        map.put('b' , 0);
        map.put('c' , 0);

        int i = 0 ;
        int j = 0 ; 
        int count = 0;

        while(j < n) {
            if(map.containsKey(ch[j])) {
                map.put(ch[j] , map.get(ch[j]) + 1);
            }

            while (map.get('a') > 0 && map.get('b') > 0 && map.get('c') > 0) {
                count = count + (n-j); 
                map.put(ch[i], map.get(ch[i]) - 1);
                i++;
            }

            j++;
        }
        return count;
    }
}