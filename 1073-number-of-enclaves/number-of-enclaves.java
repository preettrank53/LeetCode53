class Solution {

    void bfs(int[][] board , boolean[][] visited , int i , int j , int u) {

        int n = board.length;
        int m = board[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i , j});
        visited[i][j] = true;
        board[i][j] = 2;

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];

            for(int nx = x-1 ; nx<=x+1 ; nx++) {
                for(int ny = y-1 ; ny<=y+1 ; ny++) {

                    if ((nx == x - 1 && ny == y - 1) ||
                        (nx == x - 1 && ny == y + 1) ||
                        (nx == x + 1 && ny == y - 1) ||
                        (nx == x + 1 && ny == y + 1)) {
                        continue;
                    }

                    if (nx == x && ny == y) continue;

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && board[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        board[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }


    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i<n ; i++) {
            if(grid[i][0] == 1 && visited[i][0] == false) {
                bfs(grid , visited , i , 0 , 1);
            }
            if(grid[i][m-1] == 1 && visited[i][m-1] == false) {
                bfs(grid , visited , i , m-1 , 1);
            }
        }

        for(int j = 0 ; j<m ; j++) {
            if(grid[0][j] == 1 && visited[0][j] == false) {
                bfs(grid , visited , 0 , j , 1);
            }
            if(grid[n-1][j] == 1 && visited[n-1][j] == false) {
                bfs(grid , visited , n-1 , j , 1);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;  
                }
            }
        }

        return count;
    }
}