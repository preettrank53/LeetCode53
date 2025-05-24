class Solution {

    boolean allZero(Map<Character, Integer> map) {
        for (int val : map.values()) {
            if (val > 0) return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return new String("");
        }

        int n = s.length();
        int m = t.length();

        Map<Character , Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();

        for(int i = 0 ; i<m ; i++) {
            if(map.containsKey(t.charAt(i))) {
                int x = map.get(t.charAt(i));
                x++;
                map.put(t.charAt(i) , x);
            }
            else {
                map.put(t.charAt(i) , 1);
            }
        }

        int i = 0 ;
        int j = 0 ;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        while(j<n) {
            if(map.containsKey(arr[j])) {
                int x = map.get(arr[j]);
                x--;
                map.put(arr[j], x);
            }

            while(allZero(map)) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    startIndex = i;
                }

                if (map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) + 1);
                }

                i++;
            }
            j++;
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(startIndex, startIndex + minLen);
    }
}