class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int prefix = 0 ;
        int count = 0 ;

        map.put(0 , 1);

        for(int num : nums){
            prefix += num;

            int need = prefix - k;
            if(map.containsKey(need)){
                count+=map.get(need);
            }

            map.put(prefix , map.getOrDefault(prefix , 0)+1);
        }

        return count;
        
    }
}