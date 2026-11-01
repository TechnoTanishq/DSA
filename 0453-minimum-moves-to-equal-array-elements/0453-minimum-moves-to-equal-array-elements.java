class Solution {
    public int findMin(int[] nums){
        int mini = Integer.MAX_VALUE;
        int n = nums.length;
        
        for(int i = 0 ; i < n ; i++){
            mini = Math.min(mini , nums[i]);
        }

        return mini;
    }


    public int minMoves(int[] nums) {
        int n = nums.length;
        int mini = findMin(nums);
    
       

        int ans = 0 ;
        for(int i = 0; i < n; i++){
            if(nums[i] == mini)continue;
            ans += Math.abs(mini - nums[i]);
        }

        return ans ;
    }
}