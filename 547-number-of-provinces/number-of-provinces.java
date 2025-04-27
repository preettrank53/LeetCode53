class Solution {

    void BFS(Map<Integer , List<Integer>> adj , Set<Integer> visited , int u) {
        if(visited.contains(u)) {
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited.add(u);

        while(!queue.isEmpty()) {
            int node = queue.poll();

            List<Integer> near = adj.getOrDefault(node , new ArrayList<>());

            for(int i = 0 ; i<near.size() ; i++) {
                int v = near.get(i);
                if(!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }

    }

    int useBFS(Map<Integer , List<Integer>> adj , int V) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i = 0 ; i < V ; i++) {
            if(!visited.contains(i)) {
                BFS(adj , visited , i);
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

        return useBFS(map , edges.length);
    }
}