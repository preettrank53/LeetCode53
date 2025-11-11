class Solution {
    int bfs(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+'; 

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++; 

            for (int s = 0; s < size; s++) {
                int[] arr = queue.poll();
                int r = arr[0];
                int c = arr[1];

                for (int nx = r - 1; nx <= r + 1; nx++) {
                    for (int ny = c - 1; ny <= c + 1; ny++) {

                        if (nx == r - 1 && ny == c - 1 ||
                            nx == r - 1 && ny == c + 1 ||
                            nx == r + 1 && ny == c - 1 ||
                            nx == r + 1 && ny == c + 1 ||
                            nx == r && ny == c) {
                            continue;
                        }

                        if (nx < 0 || nx >= maze.length || ny < 0 || ny >= maze[0].length) {
                            continue;
                        }

                        if (maze[nx][ny] == '.') {
                            if (nx == 0 || ny == 0 || nx == maze.length - 1 || ny == maze[0].length - 1) {
                                return level;
                            }

                            maze[nx][ny] = '+';
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return -1;
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        return bfs(maze, entrance);
    }
}
