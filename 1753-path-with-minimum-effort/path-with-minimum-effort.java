class Solution {

    int bfs(int[][] grid , int[][] dist) {
        int n = grid.length;
        int m = grid[0].length;

        if(n == 0 && m == 0) return 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a , b) -> a[0] - b[0]);
        queue.add(new int[]{0 , 0 , 0 });

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int i = arr[1];
            int j = arr[2];
            int d = arr[0];

            if (i == n - 1 && j == m - 1) return d;

            for(int nx = i-1 ; nx<=i+1 ; nx++) {
                for(int ny = j-1 ; ny<=j+1 ; ny++) {

                    if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                    if(nx == i-1 && ny == j-1 ||
                       nx == i-1 && ny == j+1 ||
                       nx == i+1 && ny == j-1 ||
                       nx == i+1 && ny == j+1 ||
                       nx == i && ny == j ) {
                        continue;
                    }
                    else {

                        int newEffort = Math.max(d, Math.abs(grid[nx][ny] - grid[i][j]));
                        if (newEffort < dist[nx][ny]) {
                            dist[nx][ny] = newEffort;
                            queue.add(new int[]{newEffort, nx, ny});
                        }
                    }
                }
            }
        }
        return -1;
    }


    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m]; 

        for(int i = 0 ; i<n ; i++) {
            for(int j = 0 ; j<m ; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0; 

        return bfs(heights , dist);

    }
}