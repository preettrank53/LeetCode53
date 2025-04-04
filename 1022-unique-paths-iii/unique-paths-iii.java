class Solution {

    int dfs(int[][] grid , int r , int c , int zeros) {
        // base case 
        int rows = grid.length;
        int cols = grid[0].length;

        if(r<0 || r>=rows|| c<0 || c>=cols) {
            return 0;
        }

        if(grid[r][c]==2) {
            if(zeros==-1) {
                return 1;
            }
            return 0;
        }

        // Invalide case
        if(grid[r][c]==-1) {
            return 0;
        }

        // current position  // mark as visited
        grid[r][c] = -1;
        zeros--;

        int totalPaths = dfs(grid , r-1 , c , zeros) + 
                        dfs(grid , r , c+1 , zeros) + 
                        dfs(grid , r+1 , c , zeros) + 
                        dfs(grid , r , c-1 , zeros) ; 
        
        // backtrack
        grid[r][c] = 0;
        zeros++;

        return totalPaths;

    }

    public int uniquePathsIII(int[][] grid) {
        int sr = 0 ;  // starting row
        int sc = 0 ;  // starting column

        int zeros = 0;

        for(int i = 0 ; i<grid.length ; i++) {
            for(int j = 0 ; j<grid[0].length ; j++) {
                if(grid[i][j]==0) {
                    zeros++;
                }
                else if(grid[i][j]==1) {
                    sr = i;
                    sc = j;
                }
            }
        }

        return dfs(grid , sr , sc , zeros);
    }
}