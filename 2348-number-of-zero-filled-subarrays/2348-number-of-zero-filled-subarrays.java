class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long len = 0 ;
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0 ){
                len++;
            }
            else{
                ans += (len * (len + 1))/2;
                len = 0 ;
            }
        }
        ans += (len * (len + 1))/2;

        return ans ;
    }
}