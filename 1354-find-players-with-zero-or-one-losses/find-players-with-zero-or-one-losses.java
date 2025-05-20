class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i<matches.length ; i++) {
            int key = matches[i][1];
            int value = matches[i][0];

            if(map.containsKey(key)) {
                int n = map.get(key);
                n++;
                map.put(key , n);
            }
            else {
                map.put(key , 1);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> notLost = new ArrayList<>();
        List<Integer> oneLost = new ArrayList<>();

        for(int i = 0 ; i < matches.length ; i++) {
            int winner = matches[i][0];
            int looser = matches[i][1];

            if(!map.containsKey(winner)) {
                notLost.add(winner);
                map.put(winner , 2);
            }

            if(map.get(looser)==1) {
                oneLost.add(looser);
            }
        }

        Collections.sort(notLost);
        Collections.sort(oneLost);

        ans.add(notLost);
        ans.add(oneLost);

        return ans;
    }
}