class Solution {

    int M;
    int N;
    int[] deltaRow = {-1 , 0 , 1 , 0 };
    int[] deltaCol = {0 , 1 , 0 , -1 };

    int[][][] dp ;
 

    public int solve(int row , int col , int moves){

        if(row < 0 || row >= M || col < 0 || col >= N ){
            return 1 ; //out of boundary path found 
        }
        
        if(moves <= 0){
            return 0 ;
        }

        if(dp[row][col][moves] != -1 )return dp[row][col][moves];



        int ans = 0 ;
        for(int i = 0 ; i < 4 ; i++){
            int nrow = row + deltaRow[i];
            int ncol = col + deltaCol[i];
            ans = (ans + solve(nrow , ncol , moves-1)) % 1000000007;

        }

        return dp[row][col][moves] = ans  ;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        M=m;
        N=n;
        dp = new int[M][N][maxMove+1];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return solve(startRow , startColumn , maxMove);
    }
}