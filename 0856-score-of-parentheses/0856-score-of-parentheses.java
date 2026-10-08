class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();

        for(int i = 0 ; i < n ; i++ ){
            int val = 0 ;

            if(s.charAt(i) == '('){
                st.push(0);
            }
            else{
                while(!st.isEmpty() && st.peek() != 0 ){
                    val += st.pop();
                }
                val = (Math.max(2*val , 1));
                st.pop();
                st.push(val);              
            }
        }

        int res = 0 ;
        while(!st.isEmpty()){
            res += st.pop();
        }

        return res;
    }
}