// class Solution {
//     public int maxSubArray(int[] nums) {
//         int n = nums.length;
//         int totalSum = Integer.MIN_VALUE ;
//         int sum = Integer.MIN_VALUE ;

//         for(int i =  0 ; i < n ; i++){
//             if(sum < 0 ){
//                 sum = 0 ;
//             }
//             sum = sum + nums[i];

//             totalSum = Math.max(totalSum , sum);
//         }

//         return totalSum;
//     }
// }

class Solution {
    public int maxSubArray(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxi = dp[0];

        for(int i = 1 ; i < n ; i++){
            dp[i] = Math.max(dp[i-1]+nums[i] , nums[i]);
            maxi = Math.max(dp[i] , maxi );
        }

        return maxi ;
    }
}