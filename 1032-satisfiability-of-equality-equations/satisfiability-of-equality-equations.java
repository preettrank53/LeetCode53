class Solution {

    int find(int x , int[] parant) {
        if(x == parant[x]) {
            return x;
        }

        return parant[x] = find(parant[x] , parant);
    }

    void union(int x , int y , int[] parant , int[] rank) {
        int x_parant = find(x , parant);
        int y_parant = find(y , parant);

        if(x_parant == y_parant) {
            return;
        }

        if(rank[x_parant] > rank[y_parant]) {
            parant[y_parant] = x_parant;
        } 
        else if(rank[x_parant] < rank[y_parant]) {
            parant[x_parant] = y_parant;
        } 
        else {
            parant[x_parant] = y_parant;
            rank[y_parant]++;
        }
    }

    public boolean equationsPossible(String[] equations) {
        int[] parant = new int[26];
        int[] rank = new int[26];

        for(int i = 0 ; i < 26 ; i++) {
            parant[i] = i;
            rank[i] = 0;
        }

        // Process equalities
        for(int i = 0 ; i < equations.length ; i++) {
            String s = equations[i];

            if(s.charAt(1) == '=') {
                union(s.charAt(0) - 'a', s.charAt(3) - 'a' , parant , rank);
            }
        }

        // Process inequalities
        for(int i = 0 ; i < equations.length ; i++) {
            String s = equations[i];
            if(s.charAt(1) == '!') {
                char first = s.charAt(0);
                char second = s.charAt(3);

                
                int first_parant = find(first - 'a' , parant);
                int second_parant = find(second - 'a' , parant);

                if(first_parant == second_parant) {
                    return false;
                }
            }
        }

        return true;
    }
}
