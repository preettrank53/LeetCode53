class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        Map<Character , Integer> map = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0;
        int n = s.length();
        int count = map.size(); 

        while (j < n) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count--;
                }
            }

            if (j - i + 1 > p.length()) {
                char left = s.charAt(i);
                if (map.containsKey(left)) {
                    if (map.get(left) == 0) count++; 
                    map.put(left, map.get(left) + 1);
                }
                i++;
            }

            if (count == 0 && j - i + 1 == p.length()) {
                list.add(i);
            }

            j++;
        }

        return list;
    }
}
