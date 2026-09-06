// Approach 1 : recursive soluution - give tle for 55/66 testtcases
// class Solution {
//     public int find(int i , int j ,  String s , String t ){
//         //base case 
//         //i is for thhe string s 
//         //j is for the string t 

//         if(j < 0)return 1;
//         if(i < 0)return 0;

//         if(s.charAt(i) == t.charAt(j)){
//             return find(i-1 , j-1 , s , t ) + find(i-1 , j ,s , t );
//         }
//         else{

//             return find(i-1 , j , s , t);
//         }
//     }
//     public int numDistinct(String s, String t) {
//         int n = s.length();
//         int m = t.length();

//         return find(n-1, m-1 , s , t );
//     }
// }

//Approach 2 : Memoiization to solve the overlapping subproblem - also give tle
// class Solution {
//     public int find(int i , int j ,  String s , String t , int[][] dp){
//         //base case 
//         //i is for thhe string s 
//         //j is for the string t 

//         if(j < 0)return 1;
//         if(i < 0)return 0;

//         if(dp[i][j] != -1)return dp[i][j];

//         if(s.charAt(i) == t.charAt(j)){
//             return find(i-1 , j-1 , s , t ,dp ) + find(i-1 , j ,s , t ,dp );
//         }
//         else{

//             return find(i-1 , j , s , t , dp);
//         }
//     }
//     public int numDistinct(String s, String t) {
//         int n = s.length();
//         int m = t.length();
//         int[][] dp = new int[n][m];
        
//         //filling the dp with -1 
//         for(int i = 0 ; i < n ; i++){
//             for(int j = 0 ; j < m ;j++){
//                 dp[i][j] = -1;
//             }
//         }

//         return find(n-1, m-1 , s , t , dp );
//     }
// }


//Approach 3 : Tabulation 

class Solution {
   
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        
        //filling the dp
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ;j++){
                if(j==0){
                    dp[i][j] = 1;
                }
                else if(i==0){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = -1;
                }
            }
        }


        //logic recurrence 
        for(int i = 1 ; i < dp.length; i++){
            for(int j = 1 ; j < dp[0].length ; j++){
                            
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] =  dp[i-1][j-1] + dp[i-1][j];               
                 }
                else{

                    dp[i][j] = dp[i-1][j];  
                }
            }
        }//end of outer for 

        return dp[n][m];

    }
}