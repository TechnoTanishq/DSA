class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();

        int cnt = 0 ;

        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '(' ){
                cnt++;
                if(cnt > 1){
                    sb.append('(');
                }
            }
            else{
                if(cnt > 1){
                    sb.append(')');
                }
               
                cnt--;
            }
        }


        return sb.toString();
    }
}