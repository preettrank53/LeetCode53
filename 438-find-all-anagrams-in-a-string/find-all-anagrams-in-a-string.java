class Solution {

    boolean allZero(Map<Character, Integer> map) {
        for (int val : map.values()) {
            if (val != 0) return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        char[] arr = s.toCharArray();

        Map<Character , Integer> map = new HashMap<>();

        for(int i = 0 ; i<m ; i++) {
            if(map.containsKey(p.charAt(i))) {
                int x = map.get(p.charAt(i));
                x++;
                map.put(p.charAt(i) , x);
            }
            else {
                map.put(p.charAt(i) , 1);
            } 
        }

        int i = 0 ;
        int j = 0 ; 
        int count = 0;

        while(j<n) {
            if(map.containsKey(arr[j])) {
                int x = map.get(arr[j]);
                x--;
                map.put(arr[j] , x);
            }

            if(j-i+1==m) {
                if(allZero(map)) {
                    ans.add(i);
                }

                if(map.containsKey(arr[i])) {
                    int x = map.get(arr[i]);
                    x++;
                    map.put(arr[i] , x);
                }
                
                i++;
            }
            j++;
        }
        return ans;
    }
}