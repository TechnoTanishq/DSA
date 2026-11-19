class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        if(n<=4)return 0 ;

        int pos1 = Math.abs(nums[n-1] - nums[3]);
        int pos2 = Math.abs(nums[0] - nums[n-4]);
        int pos3 = Math.abs(nums[n-2] - nums[2]);
        int pos4 = Math.abs(nums[1]-nums[n-3]);

        int min1 = Math.min(pos1,pos2);
        int min2 = Math.min(pos3,pos4);

        return Math.min(min1,min2);
       
    }
}