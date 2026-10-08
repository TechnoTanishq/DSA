class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int counter = 0 ;
        int cur = 0 ;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                cur++;
            }
            else{
                cur--;
                if(cur < 0){
                    counter++;
                    cur++;
                }
            }
        }

        return counter + cur;
    }
}