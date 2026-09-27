class Solution {
    public String reverseParentheses(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == ')') {

                StringBuilder sb = new StringBuilder();

                while (st.peek() != '(') {
                    sb.append(st.pop());
                }

                st.pop(); //remove '('

                // Push reversed string back
                for (int j = 0; j < sb.length(); j++) {
                    st.push(sb.charAt(j));
                }

            } else {
                st.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}