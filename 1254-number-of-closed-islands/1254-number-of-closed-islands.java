class Solution {

    int[] deltaRow = {-1 , 0 , 1 , 0};
    int[] deltaCol = {0 , 1 , 0 , -1};

    public void dfs(int row , int col , int[][] grid , boolean[][] visited){

        int n = grid.length;
        int m = grid[0].length;

        visited[row][col] = true;

        for(int i = 0 ; i < 4 ; i++){
            int nrow = deltaRow[i] + row;
            int ncol = deltaCol[i] + col ;

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol]==0 && !visited[nrow][ncol]){
                dfs(nrow , ncol , grid , visited);
            }
        }
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        //traversing the row - 1st and last 

        for(int j = 0 ; j < m ; j++){
            if(grid[0][j]==0 && !visited[0][j]){
                dfs(0 , j , grid , visited );
            }

            if(grid[n-1][j]==0 && !visited[n-1][j]){
                dfs(n-1 , j , grid , visited);
            }
        }


        //traversing the 1sta dn last colum n 
        for(int i = 0 ; i < n ; i++){
            if(grid[i][0]==0 && !visited[i][0]){
                dfs(i  ,0  , grid , visited );
            }

            if(grid[i][m-1]==0 && !visited[i][m-1]){
                dfs(i , m-1 , grid , visited);
            }
        }

        int counter = 0 ;

        for(int i = 1  ; i < n-1 ; i++){
            for(int j = 1 ; j < m-1 ; j++){
                if(grid[i][j] == 0 && visited[i][j] == false){
                    dfs(i , j , grid , visited);
                    counter++;
                }
            }
        }


        return counter ;
    }
}