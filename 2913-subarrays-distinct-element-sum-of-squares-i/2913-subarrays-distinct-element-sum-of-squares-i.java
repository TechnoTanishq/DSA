class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0 ;
        Set<Integer> set = new HashSet<>();
        

        for(int i = 0 ; i < n ; i++){
            int distCount = 0 ;
            set.clear();
            for(int j = i ; j < n ;j++){
                set.add(nums.get(j));
                distCount = set.size();
                ans += distCount*distCount;
            }
        }

        return ans;
    }
}