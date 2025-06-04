class Solution {

    String reverse(String s) {
        String target = new StringBuilder(s).reverse().toString();
        return target;
    }

    boolean findRev(String target , String[] words) {
        boolean found = Arrays.asList(words).contains(target);
        return found;
    }

    int pairs = 0;
    boolean hasMiddle = false;

    public int longestPalindrome(String[] words) {
        int n = words.length;
        Map<String , Integer> map = new HashMap<>();

        for(int i = 0 ; i<n ; i++) {
            String revStr = reverse(words[i]);
            if(map.containsKey(revStr) && map.get(revStr) > 0) {
                pairs++;
                map.put(revStr, map.get(revStr) - 1);
                if (map.get(revStr) == 0) {
                    map.remove(revStr);
                }
            }
            else {
                if (map.containsKey(words[i])) {
                    int val = map.get(words[i]);
                    map.put(words[i], val + 1);
                } else {
                    map.put(words[i], 1);
                }
            }
        }
        List<String> keys = new ArrayList<>(map.keySet());

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            int value = map.get(key);

            if (key.charAt(0) == key.charAt(1) && value > 0) {
                hasMiddle = true;
                break;
            }
        }

        int result = pairs * 4;
        if (hasMiddle) result += 2;

        return result;

    }
}