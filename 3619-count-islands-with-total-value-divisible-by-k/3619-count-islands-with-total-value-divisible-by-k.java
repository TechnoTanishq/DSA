class Solution {

    public int[] dr = {-1 , 0 , 1 , 0 };
    public int[] dc = {0 , 1 , 0 , -1};

    public boolean isValid(int i , int j , int[][] grid , boolean[][] visited){
        int n = grid.length;
        int m = grid[0].length;

        if(i >= 0 && i < n && j >= 0 && j < m && visited[i][j] == false && grid[i][j] > 0){
            return true;
        }
        return false;
    }

    public void dfs(int row , int col , long[] sum , boolean[][] visited , int[][] grid)
    {
        visited[row][col] = true;
        sum[0] += grid[row][col];

        for(int i=0 ; i < 4 ; i++){
            int nrow = row + dr[i];
            int ncol = col + dc[i];

            if(isValid(nrow , ncol , grid , visited )){
                dfs(nrow , ncol ,sum , visited , grid);
            }
        }
    }

    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int count = 0 ;

        for(int i = 0 ; i < n;  i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && grid[i][j] > 0){
                    long[] sum = {0};
                    dfs(i , j , sum ,  visited , grid);
                    if(sum[0] % k == 0){
                        count++;
                    }
                }
            }
        }

        return count ;
    }
}