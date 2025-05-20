class Solution {
    public int numIdenticalPairs(int[] arr) {
        Map<Integer , Integer> map = new HashMap<>();
        int count = 0;

        for(int i = 0 ; i<arr.length ; i++) {
            if(map.containsKey(arr[i])) {
                int n = map.get(arr[i]);
                count = count + n;
                n++;
                map.put(arr[i] , n);
            }
            else {
                map.put(arr[i] , 1);
            }
        }
        return count;
    }
}