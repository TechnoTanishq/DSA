class Solution {       
    //index , tight , prev , validNum 
    int[][][][] dp ;
    int MOD = 1000000007;

    public int countSteppingNumbers(String low, String high) {

        initializeDp();
        int countNum1 = find(0,true,0,false,low);

        int i = 1 ;
        while(i < low.length()){
            if(Math.abs((low.charAt(i)-'0') - (low.charAt(i-1)-'0')) != 1){
                break;
            }
            i++;
        }
        if(i==low.length()){
            countNum1--;
        }

        initializeDp();
        int countNum2 = find(0,true,0,false,high);

        return ((countNum2 - countNum1)+MOD) % MOD;
    }

    public void initializeDp(){
        dp = new int[101][2][10][2];

        for(int[][][] a : dp ){
            for(int[][] b : a){
                for(int[] c : b)
                Arrays.fill(c , -1);
            }
        }
    }

     //index , tight , prev , validNum , String 
    public int find(int index , boolean tight , int prev , boolean validNum , String s ){
        if(index == s.length()){
            if(validNum){
                return 1;
            }
            return 0 ;
        }


        int tightVal = tight ? 1 : 0;
        int validNumVal = validNum ? 1 : 0;

        if(dp[index][tightVal][prev][validNumVal] != -1 )return dp[index][tightVal][prev][validNumVal];

        int ans = 0 ;

        int limit = tight?s.charAt(index)-'0' : 9;

        for(int d = 0 ; d <= limit ; d++){
            boolean newTight = tight && (d==(s.charAt(index)-'0'));

            if(validNum == false && d==0){
                ans = (ans +  find(index + 1 , newTight , prev , false, s)) % 1000000007 ;
            }
            else if(validNum == false && d > 0){
                ans = (ans +  find(index + 1 , newTight , d , true , s)) % 1000000007;
            }
            else if(Math.abs(d - prev) == 1){
                ans = (ans +  find(index + 1 , newTight , d , true , s)) % 1000000007;
            }
        } 

        return dp[index][tightVal][prev][validNumVal] = (int) ans ;
    }
}