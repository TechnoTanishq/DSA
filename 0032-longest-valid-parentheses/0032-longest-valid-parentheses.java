class Solution {
    public int longestValidParentheses(String s) {
        
        int n = s.length();
        
        int open = 0 ;
        int close = 0 ;

        int maxLen = 0 ;

        //left to right
        for(int i =0 ; i < n ; i++){
            char ch = s.charAt(i);

           if(ch=='(')open++;
           else{
            close++;
           }

           if(open == close){
                maxLen = Math.max(maxLen,open+close);
           }
           else if(close > open){
                open = close = 0 ;
           }
        }



        open = 0 ;
        close = 0 ;
        //right to left
        for(int i = n-1 ; i >= 0 ; i--){
            char ch = s.charAt(i);

           if(ch=='(')open++;
           else{
            close++;
           }

           if(open == close){
                maxLen = Math.max(maxLen,open+close);
           }
           else if(open > close){
                open = close = 0 ;
           }
        }
        
        return maxLen;
    }
}