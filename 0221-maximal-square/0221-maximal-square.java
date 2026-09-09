class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int maxi = 0;

        int[][] dp = new int[n][m];
        //filling the first row and first col as it is , because no more then that squares possible
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i==0 || j==0){
                    dp[i][j] = (int) (matrix[i][j] - '0');
                      maxi = Math.max(maxi , dp[i][j]);
                }
            }
        }


        //now fill the dp from (1,1)
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                if(matrix[i][j]=='1'){
                    int top = dp[i-1][j];
                    int left = dp[i][j-1];
                    int topLeft = dp[i-1][j-1];

                    dp[i][j] = 1 + Math.min(Math.min(top , left) , topLeft);
                    maxi = Math.max(maxi , dp[i][j]);
                }   
            }
        }


        return maxi * maxi ;
        
    }
}