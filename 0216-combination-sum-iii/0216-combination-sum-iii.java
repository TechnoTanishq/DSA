class Solution {

    public void find(int idx ,int sum ,  int k , int n , List<Integer> cur , List<List<Integer>> ans){
        if(sum == n && cur.size() == k){
            ans.add(new ArrayList<>(cur));
            return ;
        }

        for(int i = idx ; i <= 9 ; i++){

            //pick 
            cur.add(i);
            sum += i;

            //explore
            find(i+1 , sum , k , n , cur , ans);


            //unpick 
            sum -=i;
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> wrapList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        find(1 ,0 , k , n , list , wrapList);//idx , sum , k , n , cur list , ans list

        return wrapList;
        
    }
}


