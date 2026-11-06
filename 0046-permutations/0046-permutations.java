class Solution {
    List<List<Integer>> result;
    int n ;
    HashSet<Integer> set ;

    public void solve(int[] nums , List<Integer> temp ){

        if(temp.size() == n){
            result.add(new ArrayList<>(temp));
            return ;
        }
       
        for(int i = 0 ; i < n ; i++){
            if(set.contains(nums[i]) == false){
                temp.add(nums[i]);
                set.add(nums[i]);

                solve(nums , temp);
                
                temp.remove(temp.size() - 1);
                set.remove(nums[i]);
            }  
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        set = new HashSet<>();

         n = nums.length;

        solve(nums, temp);

        return result ;
    } 
}