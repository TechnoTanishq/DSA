// class Solution {
//     public boolean find(int x , int y , int ocount , int ccount , char[][] grid){

//         if(x >= grid.length || y >= grid[0].length)return false;

//           if(grid[x][y] == '('){
//             ocount++;
//         }
//         else{
//             ccount++;
//         }


//         if(x==grid.length-1 && y==grid[0].length - 1 && ocount==ccount){
//             return true;
//         }

//         if(x >= grid.length)return false;

//         if(y >= grid[0].length)return false ;

//         if(ccount > ocount){
//             return false;
//         }

//         boolean right = find(x, y+1 , ocount , ccount , grid);
//         boolean down = find(x+1 , y, ocount , ccount , grid);

//         return right || down ;
//     }
//     public boolean hasValidPath(char[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length ;
//         return find(0 , 0 , 0 , 0 , grid );
//     }
// }
class Solution {
    public boolean find(int x, int y, int balance, char[][] grid, Boolean[][][] dp) {

        if (x >= grid.length || y >= grid[0].length) {
            return false;
        }

        if (grid[x][y] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) {
            return false;
        }

        if (dp[x][y][balance] != null) {
            return dp[x][y][balance];
        }

        if (x == grid.length - 1 && y == grid[0].length - 1 && balance == 0) {
            return true;
        }

        boolean right = find(x, y + 1, balance, grid, dp);
        boolean down = find(x + 1, y, balance, grid, dp);

        return dp[x][y][balance] = right || down;
    }

    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if ((n + m - 1) % 2 != 0) return false;

      Boolean[][][] dp = new Boolean[n][m][n + m];

        return find(0, 0, 0, grid, dp);
    }
}