class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        String[] tokens = path.split("/");

        Stack<String> st = new Stack<>();

        for(String token : tokens){
            if(token.equals("..")){
                if(!st.empty()){
                    st.pop();
                }
            }
            else if (token.equals(".")){
                continue;
            }
            else if(token.equals("")){
                continue;
            }
            else {
                st.push(token);
            }
        }

        Stack<String> st2 = new Stack<>();
        while(!st.empty()){
            String temp = st.pop();
            st2.push(temp);
        }

        //recreating the string again 
        StringBuilder sb = new StringBuilder();
         sb.append("/");

        while(!st2.empty()){
            String temp = st2.pop();
            sb.append(temp);
            sb.append("/");
        }

        if(sb.charAt(sb.length()-1) == '/' && sb.length()>1){
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();

    }
}