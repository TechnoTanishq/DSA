class Solution {
    int nonObstacles;
    int result ;
    int n , m ;
    int[] dr = {-1 , 0 , 1, 0 };
    int[] dc = {0 , 1 , 0 , -1};

    public void backtrack(int i , int j , int count , int[][] grid){
        //invalid check 
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == -1){
            return ;
        }

        if(grid[i][j] == 2){
            if(count == nonObstacles){
                result++;
            }
            return ;
        }


        //backtrack 
        grid[i][j] = -1 ;

        for(int k = 0 ;  k < 4 ; k ++){
            int nrow = i + dr[k];
            int ncol = j + dc[k];

            backtrack(nrow , ncol , count+1 , grid);
        }
        grid[i][j] = 0 ;
        return ;        
    }
    public int uniquePathsIII(int[][] grid) {
         n = grid.length;
         m = grid[0].length;

        int count = 0 ;
        nonObstacles = 0 ;
        int startX = 0 ;
        int startY = 0 ;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    //this is the start cell 
                    startX = i;
                    startY = j;
                    nonObstacles++;
                }
                else if(grid[i][j] == 0){
                    nonObstacles++;
                }
            }
        }

        //starting from the start cell and moving forward
        backtrack(startX, startY, count , grid );

        return result;
        
    }
}