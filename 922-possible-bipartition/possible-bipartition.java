class Solution {

    boolean bfs(Map<Integer , List<Integer>> map , int[] visited , int u) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        visited[u] = 1;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int nbr : map.getOrDefault(node , new ArrayList<>())) {
                if(visited[node] == 1) {
                    if(visited[nbr] == 1) {
                        return false;
                    }
                    if(visited[nbr] == 2) {
                        continue;
                    }
                    else {
                        visited[nbr] = 2;
                        queue.offer(nbr);
                    }
                }
                else if(visited[node] == 2) {
                    if(visited[nbr] == 2) {
                        return false;
                    }
                    if(visited[nbr] == 1) {
                        continue;
                    }
                    else {
                        visited[nbr] = 1;
                        queue.offer(nbr);;
                    }
                }
            }
        }
        return true;

    }

    public boolean possibleBipartition(int n, int[][] dislikes) {

        Map<Integer , List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i<dislikes.length ; i++ ) {
            int u = dislikes[i][0];
            int v = dislikes[i][1];

            if(!map.containsKey(u)) {
                map.put(u , new ArrayList<>());
            }    
            map.get(u).add(v);

            if(!map.containsKey(v)) {
                map.put(v , new ArrayList<>());
            }
            map.get(v).add(u);
        }

        int[] visited = new int[n+1];

        for(int i = 1 ; i<=n ; i++) {
            if(visited[i] == 0) {
                if(bfs(map , visited , i) == false) {
                    return false;
                }
            }
        }

        return true;

    }
}