class Solution {
    public int findRevPos(char ch ){
        int cur = ch - 'a';
        int revPos = 26 - cur ;
        return revPos;
    }
    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0 ;

        for(int i = 0 ; i < n ; i++){
            sum = sum + ( (i+1) * findRevPos(s.charAt(i)));
        }

        return sum ;
    }
}