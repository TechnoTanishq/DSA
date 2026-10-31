class Solution {

    int MOD = 1000000007;

    int n, m;

    int left = 1;
    int up = 0;

    int[][][] dp;

    public int solve(int i, int j, int[][] grid, int cameFrom) {

        //out of bound case 
        if (i >= n || j >= m) {
            return 0;
        }

        //destination reached
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

       //already calculated - memoized 
        if (dp[i][j][cameFrom] != -1) {
            return dp[i][j][cameFrom];
        }

      //if the grid cell contains value 1 then do this 
        if (grid[i][j] == 1) {

            if (cameFrom == left) {
                return dp[i][j][cameFrom] =
                    solve(i + 1, j, grid, up);
            } 
            else {
                return dp[i][j][cameFrom] =
                    solve(i, j + 1, grid, left);
            }
        }

       //if the grid cell  contains value 0 then do this 
        int right = solve(i, j + 1, grid, left);

        int down = solve(i + 1, j, grid, up);

        return dp[i][j][cameFrom] = (right + down) % MOD;
    }

    public int uniquePaths(int[][] grid) {

        n = grid.length;
        m = grid[0].length;

        dp = new int[n][m][2];

        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 0, grid, left);
    }
}