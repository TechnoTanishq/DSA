class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int counter = 0 ;
        int maxCounter = 0 ;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                counter++;
                maxCounter = Math.max(counter, maxCounter);
            }
            else if(ch == ')'){
                counter--;
            }
        }
        return maxCounter;
    }
}