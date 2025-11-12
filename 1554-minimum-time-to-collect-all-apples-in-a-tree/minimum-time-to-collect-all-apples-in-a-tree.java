class Solution {

    int dfs(Map<Integer , List<Integer>> map , List<Boolean> hasApple , int node , int parent) {
        int time = 0 ;
        for(int child : map.getOrDefault(node , new ArrayList<>())) {
            if(child == parent) {
                continue;
            }

            int time_from_child = dfs(map , hasApple , child , node);

            if(time_from_child > 0 || hasApple.get(child) == true) {
                time = time + 2 + time_from_child;
            }
        }
        return time;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int m = edges.length;

        Map<Integer , List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i<m ; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if(!map.containsKey(u)) {
                map.put(u , new ArrayList<>());
            }
            map.get(u).add(v);

            if(!map.containsKey(v)) {
                map.put(v , new ArrayList<>());
            }
            map.get(v).add(u);
        }


        return dfs(map , hasApple , 0 , -1 );


    }
}