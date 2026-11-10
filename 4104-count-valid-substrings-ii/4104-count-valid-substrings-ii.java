class Solution {
    public long countValidSubstrings(String s) {
        int lastA = -1 ;
        int lastAB = -1 ;
        int lastBadStart = -1;
        int n = s.length();

        long count = 0 ;

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);

            if(ch == 'a'){
                lastA = i;
            }

            if(ch=='b' && lastA!=-1){
                lastAB = lastA;
            }

            if(ch == 'c' && lastAB!=-1){
                lastBadStart = Math.max(lastAB,lastBadStart);
            }

            count += i - lastBadStart;
        }

        return count;
    }
}