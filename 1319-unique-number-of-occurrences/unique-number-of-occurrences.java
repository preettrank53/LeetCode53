class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i<arr.length ; i++) {
            if(map.containsKey(arr[i])) {
                int x = map.get(arr[i]);
                x++;
                map.put(arr[i] , x);
            }
            else {
                map.put(arr[i] , 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.values());
        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i < list.size() ; i++) {
            if(set.contains(list.get(i))) {
                return false;
            }
            else {
                set.add(list.get(i));
            }
        }

        return true;
        
    }
}