class Solution {

    boolean useBFS(Map<Integer , List<Integer>> adj , int V) {
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[V];
        
        //step 1 
        
        for(int i = 0 ;i<V ;i++) {
            List<Integer> near = adj.getOrDefault(i , new ArrayList<>());
            for(int j = 0 ; j<near.size() ;j++) {
                int node = near.get(j);
                inDegree[node]++;
            }
        }
        
        // fill queue , indegree 0 fill in queue first
        int count = 0 ;
        for(int i = 0 ; i< V ; i++) {
            if(inDegree[i]==0) {
                queue.add(i);
                count++;
            }
        }
        
        //Simple BFS
        while(!queue.isEmpty()) {
            int u = queue.poll();
            List<Integer> near = adj.getOrDefault(u , new ArrayList<>());
            for(int i = 0 ; i< near.size() ; i++) {
                int node = near.get(i);
                inDegree[node]--;
                
                if(inDegree[node]==0) {
                    queue.add(node);
                    count++;
                }
            }
        }
        
        if(count==V) {
            return true;
        }
        
        return false;
        
        
    }

    public boolean canFinish(int V, int[][] edges) {
        Map<Integer , List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            // Ensure u is in the graph
            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<>());
            }
            map.get(u).add(v);

            // Ensure v is in the graph
            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<>());
            }
            
        }
        
        return useBFS(map , V);
    }
}