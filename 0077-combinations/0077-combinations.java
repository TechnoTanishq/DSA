class Solution {

    List<List<Integer>> result ;

    public void solve(int start , int n , int k  , List<Integer> temp ){

        if(k==0){
            result.add(new ArrayList<>(temp));
            return ;
        }

        if(start > n)return ;


        //take 
        temp.add(start);

        //explore 
        solve(start + 1 , n  , k-1 , temp );

        //not take 
        temp.remove(temp.size()-1);

        // explore
        solve(start + 1 , n , k , temp);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(1, n , k , temp);//start , end , k , temp 

        return result ;
    }
}