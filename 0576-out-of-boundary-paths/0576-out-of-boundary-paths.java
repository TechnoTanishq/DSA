   class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int MOD = 1_000_000_007;
        
        // dp[row][col][moves]
        int[][][] dp = new int[m][n][maxMove + 1];
        
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

       
        for (int moves = 1; moves <= maxMove; moves++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    long ans = 0;
                    
                    // 4 direction traversal 
                    for (int itr = 0; itr < 4; itr++) {
                        int nrow = i + deltaRow[itr];
                        int ncol = j + deltaCol[itr];

                        if (nrow < 0 || nrow >= m || ncol < 0 || ncol >= n) {
                            ans = (ans + 1) % MOD;
                        } else {
                            ans = (ans + dp[nrow][ncol][moves - 1]) % MOD;
                        }
                    }
                    
                    dp[i][j][moves] = (int) ans;
                }
            }
        }

        return dp[startRow][startColumn][maxMove];
    }
}