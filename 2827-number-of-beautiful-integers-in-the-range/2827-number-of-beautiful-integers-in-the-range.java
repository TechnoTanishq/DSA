class Solution {
    //index , tight , evenCount , oddCount , validNum
    int[][][][][][] dp ;

    public int find(int index , boolean tight , int oddCount , int evenCount , int remainder , boolean validNum , int k , String s){
        if(index >= s.length()){
            if(oddCount == evenCount  &&  remainder == 0 ){
                return 1 ;
            }
            return 0 ; 
        }


        //even - odd purning 
        if(oddCount > 5 || evenCount > 5){
            return 0 ; 
        }

        //already calculated 
        int tightVal = tight? 1 : 0 ;
        int validNumVal = validNum ? 1 : 0;

        if(dp[index][tightVal][oddCount][evenCount][remainder][validNumVal] != -1){
            return dp[index][tightVal][oddCount][evenCount][remainder][validNumVal];
        }

        int ans = 0 ;
        int limit = tight ? s.charAt(index)-'0':9;

        //for loops 
 
        for(int d = 0 ; d <= limit ; d++){
            boolean newTight = tight && (d==s.charAt(index)-'0');
// public int find(int index , boolean tight , int oddCount , int evenCount , int remainder , boolean validNum , int k , String s){
            if(validNum == false && d==0){
                //handle the leading zeros 
                ans += (find(index+1 , newTight , oddCount , evenCount , remainder , false , k , s ));
            }
            else if(d%2==0){
                //number is even 
                ans += (find(index + 1 , newTight , oddCount , evenCount + 1  , (remainder*10 + d)%k , true , k , s ));
            }
            else{
                ans += (find(index + 1 , newTight , oddCount + 1 , evenCount , (remainder*10 + d)%k , true , k , s ));
            }
        }
        
        return dp[index][tightVal][oddCount][evenCount][remainder][validNumVal] = ans ;
    }

    public void initializeDp(){
        dp = new int[10][2][6][6][20][2];

        for(int[][][][][] a : dp){
            for(int[][][][] b : a){
                for(int[][][] c : b){
                    for(int[][] d : c){
                        for(int[] e : d){
                            Arrays.fill(e , -1);
                        }
                    }
                }
            }
        }
    }

    public int numberOfBeautifulIntegers(int low, int high, int k) {

        String l = String.valueOf(low-1);
        initializeDp();
        int count1 = find(0 , true , 0 , 0 , 0 , false , k , l);


        String h = String.valueOf(high);
        initializeDp();
        int count2 = find(0 , true , 0 , 0 , 0 , false , k , h);


        return count2 - count1;
    }
}