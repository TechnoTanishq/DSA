// class Solution {

//     int[] dp ;

//     public int find(int i , int n , int[] costs){

//         if(i==n)return 0;
//         if(i>n)return (int)1e9;

//         if(dp[i]!=-1)return dp[i];

//         int a = (int)1e9;
//         int b = (int)1e9;
//         int c = (int)1e9;

//         if(i+1 <= n){
//          a = (costs[i] + ((i+1) - i)*((i+1) - i)) + find(i+1 , n , costs);
//         }

//         if(i+2 <= n){
//              b = (costs[i+1] + ((i+2) - i)*((i+2) - i)) + find(i+2 , n , costs);
//         }

//         if(i+3 <= n){
//             c = (costs[i+2] + ((i+3) - i)*((i+3) - i))  + find(i+3 , n , costs);
//         }

//         return dp[i] = Math.min(a,Math.min(b,c));
//     }
//     public int climbStairs(int n, int[] costs) {
//         dp = new int[n];
//         Arrays.fill(dp , -1 );

//         return find(0,n,costs);
//     }
// }

class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        dp[n] = 0 ;

        for(int i = n-1 ; i >= 0 ; i--){
                int a = (int)1e9;
                int b = (int)1e9;
                int c = (int)1e9;

                if(i+1 <= n){
                a = (costs[i] + ((i+1) - i)*((i+1) - i)) + dp[i+1];
                }

                if(i+2 <= n){
                    b = (costs[i+1] + ((i+2) - i)*((i+2) - i)) + dp[i+2];
                }

                if(i+3 <= n){
                    c = (costs[i+2] + ((i+3) - i)*((i+3) - i))  + dp[i+3];
                }

                dp[i] = Math.min(a,Math.min(b,c));
        }

        return dp[0];   
        
    }
}