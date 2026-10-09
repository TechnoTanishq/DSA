class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int ans = 0 ;

     

        for(int i = 0  ; i < n ; i++){
            if(s.charAt(i) == '('){
                st.push('(');
            }
            else{
                //check for next consecutivwe

                if(i+1 < s.length() && s.charAt(i+1)==')'){
                    i++;
                }
                else{
                    ans++;//adding a ) if not present 
                }


                //poping from stack
                if(!st.isEmpty()){
                    st.pop();
                }
                else{
                    ans++;
                }
            }
        }


        while(!st.isEmpty()){
            st.pop();
            ans+=2;
            
        }
        return ans ;
    }
}