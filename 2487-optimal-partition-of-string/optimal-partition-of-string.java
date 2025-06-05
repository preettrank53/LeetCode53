class Solution {
    public int partitionString(String s) {
        int n = s.length();
        int count = 0;

        Map<Character , Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++) {
            if(map.containsKey(s.charAt(i))) {
                map.clear();
                count++;
                map.put(s.charAt(i) , 1);
            }
            else {
                map.put(s.charAt(i) , 1);
            }
        }

        if(count==0) {
            return 1;
        }

        if(map.size()>1) {
            count = count + 1;
            return count;
        }

        count = count + map.size();
        return count;
    }
}