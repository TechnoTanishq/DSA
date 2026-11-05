// class Solution {

//     public boolean dfs(int i, int j, int idx,
//                        char[][] board,
//                        boolean[][] check,
//                        String word) {

        
//         if (idx == word.length()) {
//             return true;
//         }

//         check[i][j] = true;

//         int[] deltaRow = {-1, 0, 1, 0};
//         int[] deltaCol = {0, 1, 0, -1};

//         for (int k = 0; k < 4; k++) {

//             int row = i + deltaRow[k];
//             int col = j + deltaCol[k];

//             if (row >= 0 &&
//                 row < board.length &&
//                 col >= 0 &&
//                 col < board[0].length &&
//                 !check[row][col] &&
//                 board[row][col] == word.charAt(idx)) {

//                 if (dfs(row, col, idx + 1, board, check, word)) {
//                     return true;
//                 }
//             }
//         }

//         // Backtracking
//         check[i][j] = false;

//         return false;
//     }

//     public boolean exist(char[][] board, String word) {

//         int n = board.length;
//         int m = board[0].length;

//         boolean[][] check = new boolean[n][m];

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {

//                 if (board[i][j] == word.charAt(0)) {

//                     if (dfs(i, j, 1, board, check, word)) {
//                         return true;
//                     }
//                 }
//             }
//         }

//         return false;
//     }
// }


// using backtracking

class Solution {
    int n ;
    int m ;

    int[] dr = {-1 , 0 , 1 , 0 };
    int[] dc = {0 , 1 , 0 , -1 };

    //find(i,j,0,board , word)
    public boolean find(int i , int j , int idx , char[][] board , String word){
        if(idx == word.length())return true;    //full word traversed 
        if(i<0 || j<0 || i>=n || j>=m || board[i][j] =='$' ){
            return false;   //invalid cases 
        }
        if(board[i][j] != word.charAt(idx))return false;

        //mark and store the current char 
        char temp = board[i][j];
        board[i][j] = '$';

        //traverse 4 directionally 
        for(int k = 0 ; k < 4 ;k++){
            int nrow = i + dr[k];
            int ncol = j + dc[k];

            if(find(nrow , ncol , idx+1 , board , word)){
                return true;
            }
        }


        board[i][j] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ;j < m ; j++){
                if(board[i][j] == word.charAt(0)){
                    if(find(i,j,0,board , word)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}