class Solution {
    int n ;

    public int find( int[] nums , int target,int[] dp){
        if(target==0)return 1 ;
        if(target<0)return 0 ;

        if(dp[target] != -1)return dp[target];

        int ways = 0 ;

        for(int num : nums){
            ways += find(nums , target-num , dp );
        }

        return dp[target] =  ways;

    }
    public int combinationSum4(int[] nums, int target) {
        n = nums.length;
        int[] dp = new int[target+1];
        Arrays.fill(dp , -1);
        return find(nums , target, dp);

    }
}