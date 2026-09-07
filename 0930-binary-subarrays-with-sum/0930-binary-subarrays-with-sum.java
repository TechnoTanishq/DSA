// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//             int res = getSum(nums,goal) - getSum(nums,goal-1);
//             return res;
//     }
    
//     public int getSum(int[] nums , int goal){
//         if(goal < 0)return 0;
//         int r=0;
//         int l=0;
//         int sum=0;
//         int counter=0;

//         while(r < nums.length){
//             sum+=nums[r];
//             while(sum > goal){
//                 sum = sum - nums[l];
//                 l=l+1;
//             }
//             counter +=(r-l+1);
//             r++;
//         }

//         return counter;
//     }
// }
//brute force - O(n square)
//         int n = nums.length;
//         int counter=0;

//         for(int i = 0 ; i < n ; i++){
//             int sum = 0 ;
//             for(int j = i ; j < n ; j++){
//                 sum = sum + nums[j];
//                 if(sum==goal){
//                      counter+=1;
//                 }
//             }
//         }
//         return counter;


class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0 , 1); //prefix and its frequency

        int prefix = 0 ;
        int ans = 0 ;

        for(int num : nums){
            prefix += num;

            int need = prefix - goal;

            if(map.containsKey(need)){
                ans += map.get(need);
            }

            map.put(prefix , map.getOrDefault(prefix , 0)+1);
        }

        return ans ;
    }
}