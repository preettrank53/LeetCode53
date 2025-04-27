class Solution {

    void DFS(Map<Integer , List<Integer>> adj , Set<Integer> visited , int u) {
        if(visited.contains(u)) {
            return;
        }
        visited.add(u);

        List<Integer> list = adj.getOrDefault(u, new ArrayList<>());
        for(int i = 0 ; i<list.size() ; i++) {
            int v = list.get(i);
            if(!visited.contains(v)) {
                DFS(adj , visited , v);
            }
        }
    }

    int useDFS(Map<Integer , List<Integer>> adj , int V) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i = 0 ; i < V ; i++) {
            if(!visited.contains(i)) {
                DFS(adj , visited , i);
                count++;
            }
        }
        return count;
    }

    public int findCircleNum(int[][] edges) {
        Map<Integer , List<Integer>> map = new HashMap<>();
        
        for(int i = 0 ; i<edges.length ; i++) {
            for(int j = 0 ; j<edges.length ; j++) {
                if(edges[i][j]==1 && i!=j) {
                    if(!map.containsKey(i)) {
                        map.put(i , new ArrayList<>());
                    }
                    map.get(i).add(j);

                    if(!map.containsKey(j)) {
                        map.put(j , new ArrayList<>());
                    }
                    map.get(j).add(i);
                }
            }
        }

        return useDFS(map , edges.length);
    }
}