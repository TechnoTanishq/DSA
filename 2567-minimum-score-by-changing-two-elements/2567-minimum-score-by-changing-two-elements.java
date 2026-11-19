class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int pos1 = nums[n-1]-nums[2];
        int pos2 = nums[n-3]-nums[0];
        int pos3 = nums[n-2]-nums[1];
        return Math.min(pos1 , Math.min(pos2 , pos3));

    }
}