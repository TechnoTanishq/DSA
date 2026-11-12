class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int increment=1 ;
        int decrement=1 ;
        int ans = 1 ;

        for(int i = 0 ; i < n-1 ; i++){
            if(nums[i] < nums[i+1]){
                increment++;
            }
            else{
                increment = 1 ;
            }

            if(nums[i]> nums[i+1]){
                decrement++;
            }
            else{
                decrement=1;
            }

            ans = Math.max(ans , Math.max(increment , decrement));
        }

        return ans ;
    }
}