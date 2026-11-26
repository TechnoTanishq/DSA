class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10)return false;
        int k = 10 ;
        boolean isAlice = false;

        while(n > 0){
            if(n >= k){
                n = n - k; // n = 0
                k--; //k = 8
                isAlice = !isAlice;
            }
            else{
                return isAlice;
            }
        }
        return isAlice;
    }
}