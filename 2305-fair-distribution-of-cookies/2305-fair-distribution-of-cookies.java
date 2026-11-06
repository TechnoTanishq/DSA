class Solution {

    int n ;
    int result;

    public int findMax(List<Integer> list){
        int maxi = Integer.MIN_VALUE;

        for(int num : list){
            maxi = Math.max(num , maxi );
        }

        return maxi;
    }

    public void solve(int idx ,  int[] cookies , int k , List<Integer> children){
        
        if(idx >= n){
            //store the unfaireness 

            int unfairness = findMax(children);
            result = Math.min(result , unfairness);
            return ;
        }

        int cookie = cookies[idx];

        for(int i = 0 ; i < k ; i++ ){
            int newVal = children.get(i) + cookie;

            children.set(i, newVal);
            solve(idx+1 ,cookies , k , children );
            children.set(i, children.get(i) - cookie);
        }
    }
    public int distributeCookies(int[] cookies, int k) {
        n = cookies.length;
        result = Integer.MAX_VALUE;
        List<Integer> children = new ArrayList<>();
        for (int i = 0; i < k; i++) children.add(0);

        solve(0 , cookies , k , children);

        return result;
    }
}