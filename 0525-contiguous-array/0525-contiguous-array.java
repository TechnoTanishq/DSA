class Solution {
    public int findMaxLength(int[] nums) {
        int  n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0 , -1);
        int maxLen = 0 ;

        int prefix = 0 ;
        int count = 0 ;

        for(int i = 0 ; i < n ; i++){
            int num = nums[i];
            if(num == 0){
                num = -1;
            }

            prefix += num;
            if(map.containsKey(prefix)){
                maxLen = Math.max(maxLen , i - map.get(prefix));
            }

            if(!map.containsKey(prefix)){
                map.put(prefix , i);
            }


        }

        return maxLen ;
    }
}