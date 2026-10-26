import java.util.*;

class Pair {
    int row;
    int col;
    int count;

    public Pair(int r, int c, int cnt) {
        this.row = r;
        this.col = c;
        this.count = cnt;
    }
}

class Solution {

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int shortestBridge(int[][] grid) {

        int n = grid.length;

        boolean[][] visited = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();

        boolean found = false;

        //Finding and mark the first island
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    dfs(i, j, q, visited, grid);
                    found = true;
                    break;
                }
            }
        }

        //Multi-source BFS
        while (!q.isEmpty()) {

            Pair cur = q.poll();

            int row = cur.row;
            int col = cur.col;
            int cnt = cur.count;

            for (int i = 0; i < 4; i++) {

                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < n &&
                    !visited[nrow][ncol]) {

                    //reached the second island
                    if (grid[nrow][ncol] == 1) {
                        return cnt;
                    }

                    //expand through water
                    visited[nrow][ncol] = true;

                    q.add(new Pair(nrow, ncol, cnt + 1));
                }
            }
        }

        return 0;
    }

    // mark the entire first island and add its cells to the queue
    public void dfs(int row, int col, Queue<Pair> q,
                    boolean[][] visited, int[][] grid) {

        int n = grid.length;

        visited[row][col] = true;
        q.add(new Pair(row, col, 0));

        for (int i = 0; i < 4; i++) {

            int nrow = row + dr[i];
            int ncol = col + dc[i];

            if (nrow >= 0 && nrow < n &&
                ncol >= 0 && ncol < n &&
                grid[nrow][ncol] == 1 &&
                !visited[nrow][ncol]) {

                dfs(nrow, ncol, q, visited, grid);
            }
        }
    }
}