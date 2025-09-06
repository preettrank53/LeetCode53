import java.util.*;

class Solution {

    boolean allZero(Map<Character, Integer> map) {
        for (int val : map.values()) {
            if (val != 0) return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int m = s1.length();

        if (m > n) return false;

        char[] arr = s2.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0;

        while (j < n) {
            if (map.containsKey(arr[j])) {
                map.put(arr[j], map.get(arr[j]) - 1);
            }

            if (j - i + 1 == m) {
                if (allZero(map)) {
                    return true; 
                }
                
                if (map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) + 1);
                }
                i++;
            }
            j++;
        }

        return false;
    }
}
