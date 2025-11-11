class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                int node = queue.poll();

                if (node == destination) return true;

                for (int i = 0; i < adj.get(node).size(); i++) {
                    int nbr = adj.get(node).get(i);
                    if (!visited[nbr]) {
                        visited[nbr] = true;
                        queue.offer(nbr);
                    }
                }
            }
        }

        return false;
    }
}
