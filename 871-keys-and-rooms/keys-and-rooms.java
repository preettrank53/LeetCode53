class Solution {

    void bfs(List<List<Integer>> rooms , boolean[] visited , int u) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        visited[u] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> list = rooms.get(node);

            for(int i=0 ; i<list.size() ; i++) {
                if(visited[list.get(i)] == false) {
                    queue.offer(list.get(i));
                    visited[list.get(i)] = true;
                }
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();
        boolean[] visited = new boolean[n];

        bfs(rooms , visited , 0);

        for(int i = 0 ; i<n ; i++) {
            if(visited[i] == false) {
                return false;
            }
        }
        return true;
    }
}