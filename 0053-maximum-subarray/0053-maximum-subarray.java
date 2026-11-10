class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int totalSum = Integer.MIN_VALUE ;
        int sum = Integer.MIN_VALUE ;


        for(int i =  0 ; i < n ; i++){
            if(sum < 0 ){
                sum = 0 ;
            }
            sum = sum + nums[i];

            totalSum = Math.max(totalSum , sum);
        }

        return totalSum;
    }
}