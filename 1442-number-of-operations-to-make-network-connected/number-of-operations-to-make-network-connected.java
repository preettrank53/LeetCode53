class Solution {

    int find(int x , int[] parant) {
        if(x==parant[x]) {
            return x;
        }

        return parant[x] = find(parant[x] , parant);
    }

    void union(int x , int y , int[] parant , int[] rank) {
        int x_parant = find(x , parant);
        int y_parant = find(y , parant);

        if(x_parant==y_parant) {
            return;
        }

        if(rank[x_parant] > rank[y_parant]) {
            parant[y_parant] = x_parant;
        }

        else if(rank[x_parant] < rank[y_parant]) {
            parant[x_parant] = y_parant;
        }

        else {
            parant[y_parant] = x_parant;
            rank[x_parant]++;
        }
    }

    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n-1) {
            return -1;
        }
        
        int[] parant = new int[n];
        int[] rank = new int[n];

        for(int i = 0 ; i<n ; i++) {
            parant[i] = i;
            rank[i] = 0;
        }

        int components = n; // illaka

        for(int i = 0 ; i < connections.length ; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            int u_parant = find(u , parant);
            int v_parant = find(v , parant);

            if(u_parant != v_parant) {
                union(u , v , parant , rank);
                components--;
            }
        }

        return components-1;
    }
}