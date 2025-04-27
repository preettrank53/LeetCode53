class Solution {
    int count = 0;
    void useBFS(Map<Integer , List<Integer>> adj , int V , List<Integer> result ) {
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
        for(int i = 0 ; i< V ; i++) {
            if(inDegree[i]==0) {
                queue.add(i);
                result.add(i);
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
                    result.add(node);
                    count++;
                }
            }
        }
        
    }

    public int[] findOrder(int V, int[][] edges) {

        List<Integer> result = new ArrayList<>();

        Map<Integer , List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][1];
            int v = edges[i][0];

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
        
        useBFS(map , V , result);
        if(count!=V) {
            return new int[]{};
        }
        int[] ans = new int[V];
        for(int i = 0 ; i<result.size() ; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}