class Solution {

    int bfs(Map<Integer, List<List<Integer>>> map, long[] dist, int n) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, 0});
        final int MOD = 1_000_000_007;

        long[] ways = new long[n];
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] arr = pq.poll();
            long t = arr[0];
            int u = (int)arr[1];

            if (t > dist[u]) continue;

            for (List<Integer> pair : map.getOrDefault(u, new ArrayList<>())) {
                int v = pair.get(0);
                long T = pair.get(1);

                if (dist[v] > t + T) {
                    dist[v] = t + T;
                    pq.add(new long[]{dist[v], v});
                    ways[v] = ways[u];
                } else if (dist[v] == t + T) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return (int) (ways[n - 1] % MOD);
    }

    public int countPaths(int n, int[][] roads) {
        int m = roads.length;

        Map<Integer , List<List<Integer>>> map = new HashMap<>();

        for(int i = 0 ; i<m ; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int t = roads[i][2];

            if(!map.containsKey(u)) {
                map.put(u , new ArrayList<>());
            }
            map.get(u).add(Arrays.asList(v , t));

            if(!map.containsKey(v)) {
                map.put(v , new ArrayList<>());
            }
            map.get(v).add(Arrays.asList(u , t));
        }

        long[] dist = new long[n];

        for(int i = 0 ; i<n ; i++) {
            dist[i] = Long.MAX_VALUE;
        }

        dist[0] = 0;

        return bfs(map , dist , n);
    }
}