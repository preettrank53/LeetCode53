class Solution {

    int findParent(int x, int[] parent) {
        if (parent[x] == x) return x;  
        return parent[x] = findParent(parent[x], parent); 
    }

    void union(int x, int y, int[] parent, int[] rank) {
        int px = findParent(x, parent);
        int py = findParent(y, parent);

        if (px == py) return; 

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j, parent, rank);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) count++;
        }

        return count;
    }
}
