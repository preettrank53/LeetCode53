class Solution {
    public int minimumRounds(int[] tasks) {
        int n = tasks.length;

        Map<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i<n ; i++) {
            if(map.containsKey(tasks[i])) {
                map.put(tasks[i] , map.get(tasks[i])+1);
            }
            else {
                map.put(tasks[i] , 1);
            }
        }

        int count = 0;

        List<Integer> list = new ArrayList<>(map.keySet());

        for(int i = 0 ; i<map.size() ; i++ ) {

            int key = list.get(i);
            int freq = map.get(key); // store in a local variable

            if (freq == 1) {
                return -1;
            }

            while (freq > 0) {
                if (freq == 2 || freq % 3 == 1) {
                    freq = freq - 2;
                    count++;
                } 
                else {
                    freq = freq - 3;
                    count++;
                }
            }

            
        }
        return count;
    }
}