class Solution {
    public void solve(int open , int close , String str , List<String> ans){
        if(open==0 && close==0 ){
            ans.add(
                new String(str));
            return ;
        }

        if(open!=0){
            solve(open-1,close,str+'(',ans);
        }
        if(close > open){
            solve(open,close-1,str+')',ans);
        }
        return ;
    }

    public List<String> generateParenthesis(int n) {
        int open = n;
        int close = n;
        String str = "";
        List<String> ansList = new ArrayList<>();
        solve(open,close,str,ansList);
        return ansList;
    }
}