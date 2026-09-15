class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int n = nums.length;
        int res[] = new int[2];

        for(int i = 0 ; i< n ;i++){
            int req = target-nums[i];

            if(map.containsKey(req)){
                return new int[]{map.get(req), i};
            }
            else{
                map.put(nums[i],i);
            }
        }
         return new int[]{};

     
    }
}