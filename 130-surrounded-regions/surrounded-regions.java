class Solution {

    void bfs(char[][] board , boolean[][] visited , int i , int j , char u) {

        int n = board.length;
        int m = board[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i , j});
        visited[i][j] = true;
        board[i][j] = '#';

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

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && board[nx][ny] == 'O') {
                        visited[nx][ny] = true;
                        board[nx][ny] = '#';
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) bfs(board, visited, i, 0, 'O');
            if (board[i][m - 1] == 'O' && !visited[i][m - 1]) bfs(board, visited, i, m - 1, 'O');
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) bfs(board, visited, 0, j, 'O');
            if (board[n - 1][j] == 'O' && !visited[n - 1][j]) bfs(board, visited, n - 1, j, 'O');
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';  
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';  
                }
            }
        }
    }
}
