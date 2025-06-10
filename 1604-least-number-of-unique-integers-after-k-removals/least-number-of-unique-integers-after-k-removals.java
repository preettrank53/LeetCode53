class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < arr.length ; i++) { 
            if(map.containsKey(arr[i])) {
                 map.put(arr[i] , map.get(arr[i])+1); 
            }
            else { 
                map.put(arr[i] , 1);
            }
        }

        int[] values = new int[map.size()];
        int idx = 0;
        for (int freq : map.values()) {
            values[idx++] = freq;
        }

        Arrays.sort(values);

        int i = 0, j = 0;
        while (j < values.length) {
            k -= values[j];

            if (k < 0) break;

            j++;
        }

        // The number of unique integers left = total unique - removed ones
        return values.length - j;
    }
}
