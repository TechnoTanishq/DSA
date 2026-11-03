class Solution {
    int n ;
    int totalSum;

    public int findMaxi(int[] nums){
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < n; i++){
            maxi = Math.max(maxi , nums[i]);
            totalSum += nums[i];
        }

        return maxi ;
    }
    public int minMoves(int[] nums) {
        n = nums.length;
        int maxi = findMaxi(nums);
        int need = maxi * n ;
        int cur = totalSum;

        return need - cur;
    }
}