class Solution {

    boolean DFS(Map<Integer , List<Integer>> adj , Map<Integer, Integer> colour , int u , int currColour) {
        colour.put(u, currColour); // colour kar diya currnt node ko 

        // ab connected node ko colour karte ye with diffrent colour
        List<Integer> near = adj.getOrDefault(u , new ArrayList<>());
        for(int i = 0 ; i<near.size() ; i++) {
            int v = near.get(i);
            if (colour.containsKey(v)) {
                if (colour.get(v) == colour.get(u)) {
                    return false;
                }
            } 
            else {
                if (currColour == 1) {
                    if (DFS(adj, colour, v, 0) == false) {
                        return false;
                    }
                }
                if (currColour == 0) {
                    if (DFS(adj, colour, v, 1) == false) {
                        return false;
                    }
                }
            }
            
        }

        return true;
    }

    boolean useDFS(Map<Integer , List<Integer>> adj , int V ) {
        Map<Integer, Integer> colour = new HashMap<>();
        for(int i = 0 ; i<V ; i++) {
            if(!colour.containsKey(i)) {
                if(DFS(adj , colour , i , 1)==false) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] edges) {
        Map<Integer , List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < edges.length; i++) {
            int u = i;

            for(int j = 0 ; j<edges[i].length ; j++) {
                int v = edges[u][j];

                // Ensure u is in the graph
                if (!map.containsKey(u)) {
                    map.put(u, new ArrayList<>());
                }
                map.get(u).add(v);

                // Ensure v is in the graph
                if (!map.containsKey(v)) {
                    map.put(v, new ArrayList<>());
                }
                map.get(v).add(u); // Since it's undirected, add both ways
            }
            
        }

        return useDFS(map , edges.length);
    }
}