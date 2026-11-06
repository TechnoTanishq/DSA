class Solution {

    public void solve(int idx , int[] nums , List<Integer> cur , List<List<Integer>> ans ){
      
            if(cur.size() >= 2){
                ans.add(new ArrayList<>(cur));
            }

            HashSet<Integer> set = new HashSet<>();
        

        for(int i = idx ; i < nums.length; i++){
            if((cur.size() == 0 || nums[i] >= cur.get(cur.size() -1 )) && set.contains(nums[i]) == false){
                cur.add(nums[i]);
                solve(i+1 , nums , cur , ans );
                cur.remove(cur.size() - 1);

                set.add(nums[i]);
            }
        }
    }


    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        solve(0 , nums, cur , ans);

        return ans ;
    }
}