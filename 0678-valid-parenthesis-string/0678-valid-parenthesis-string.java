class Solution {
    public boolean solve(int i , int open , String s , Boolean[][] dp){
       //base cases 
       if(open < 0)return false;


       if( i == s.length()){
        return open==0;

       }

       if(dp[i][open] != null){
        return dp[i][open];
       }


        boolean isValid = false;       
            char ch = s.charAt(i);

            if(ch == '('){
               isValid =  solve(i+1 , open+1 , s , dp);
            }
            else if(ch == '*'){
                isValid = 
                solve(i+1 , open+1 , s, dp) || 
                solve(i+1 , open , s , dp)|| 
                solve(i+1 , open-1 , s, dp);
            }
            else{
               isValid =  solve(i+1 , open -1 , s, dp);
            }
     
          return dp[i][open] = isValid;
    }
    public boolean checkValidString(String s) {
        
        int n = s.length();
        int open = 0 ;

        Boolean[][] dp = new Boolean[n][n];
        
     
        boolean res = solve(0 , open , s , dp);
        
        return res ;
    }
}