import java.util.*;

class Solution {
    public int networkDelayTime(int[][] edges, int n, int src) {
        // Initialize adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph from edges
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            adj.get(u).add(new ArrayList<>(Arrays.asList(v, weight)));
        }

        // Priority Queue to pick the minimum distance node
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.get(0), b.get(0)));

        // Distance array
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        result[src] = 0;

        pq.add(Arrays.asList(0, src)); // (distance, node)

        // Dijkstra's Algorithm
        while (!pq.isEmpty()) {
            List<Integer> top = pq.poll();
            int dist = top.get(0);
            int node = top.get(1);

            ArrayList<ArrayList<Integer>> near = adj.get(node);
            for (int i = 0; i < near.size(); i++) {
                ArrayList<Integer> neighbor = near.get(i);
                int v = neighbor.get(0);
                int weight = neighbor.get(1);

                if (dist + weight < result[v]) {
                    result[v] = dist + weight;
                    pq.add(Arrays.asList(result[v], v));
                }
            }
        }

        // Find the maximum distance from source to any node
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (result[i] == Integer.MAX_VALUE)
             return -1; // unreachable node
            max = Math.max(max, result[i]);
        }

        return max;
    }
}
