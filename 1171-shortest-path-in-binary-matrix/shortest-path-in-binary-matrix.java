class Solution {

    int bfs(int[][] grid , int[][] dist) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) {
            return -1;
        }
        if(n == 1 && m == 1) {
            return 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0 , 0 , 1});

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int i = arr[0];
            int j = arr[1];
            int w = arr[2];

            for(int nx = i - 1; nx <= i + 1; nx++) {
                for(int ny = j - 1; ny <= j + 1; ny++) {
    
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                    if(nx == i && ny == j) {
                        continue;
                    }

                    if(grid[nx][ny] == 0 && dist[nx][ny] > w + 1) {
                        dist[nx][ny] = w + 1;

                        if(nx == n-1 && ny == m-1) return w + 1;
    
                        queue.offer(new int[]{nx , ny , w + 1});
                    }
                }
            }
        }
        return -1;
    }


    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        
        for(int i = 0 ; i<n ; i++) {
            for(int j = 0 ; j<m ; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dist[0][0] = 1;
        
        return bfs(grid , dist);
    }
}