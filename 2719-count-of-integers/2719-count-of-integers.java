class Solution {
    long[][][] dp;
      int MOD = 1000000007;


    public int count(String num1, String num2, int min_sum, int max_sum) {
        
      
        // 0 to num1
        initializeDp();
        long countNum1 = find(0 , true , 0 , min_sum , max_sum , num1);

        //0 to num2
        initializeDp();
        long countNum2 = find(0 , true , 0 , min_sum , max_sum , num2);


        int sum = 0 ;
        for(char ch : num1.toCharArray()){
            sum += (ch-'0');
        }

        if(sum >= min_sum && sum <= max_sum){
            countNum1--;
        }


       long ans = (countNum2 - countNum1) % MOD;
        if (ans < 0) ans += MOD;
        return (int) ans;
    }

    public void initializeDp(){
        dp = new long[23][2][401];

        for(long[][] matrix : dp){
            for(long[] row : matrix){
                Arrays.fill(row , -1);
            }
        }
    }

    public long find(int index , boolean tight , int sum , int minSum , int maxSum , String s ){
        if(index==s.length()){
            if(sum >= minSum && sum <= maxSum){
                return 1 ;
            }
            return 0 ;
        }

        int tightVal = tight ? 1 : 0 ;

        if(dp[index][tightVal][sum] != -1)return dp[index][tightVal][sum];



        long ans = 0 ;

        int limit = tightVal == 1 ? (s.charAt(index)-'0') : 9;

        for(int d = 0 ; d <= limit ; d++){

            boolean newTight = tight && (d==limit);
            ans = ( ans +  find(index + 1 , newTight , sum+d , minSum , maxSum , s )) % MOD ;
        }

        return dp[index][tightVal][sum] =  ans ;
    }
}