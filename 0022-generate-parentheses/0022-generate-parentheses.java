class Solution {

    public boolean isValid(String str){
        int cnt = 0 ;
        for(char ch : str.toCharArray()){
            if(ch == '('){
                cnt++;
            }
            else{
                cnt--;
            }
        }

        return cnt==0;
    }

    public void solve(int open , int close , int n ,
     StringBuilder sb , List<String> list){
        if(sb.length() == 2*n){
            //check if its valid
            if(isValid(sb.toString())){
                list.add(sb.toString());
                return ;
            }
            else{
                return ;
            }
        }

        if(open < n ){
            solve(open+1 , close , n , sb.append('(') , list);

            sb.deleteCharAt(sb.length()-1);
        }
        
        if(close < open){
            solve(open , close+1 , n , sb.append(')') , list);

            sb.deleteCharAt(sb.length() - 1);
        }
        
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        solve(0 , 0 ,n, sb , list);

        return list;
        
    }
}