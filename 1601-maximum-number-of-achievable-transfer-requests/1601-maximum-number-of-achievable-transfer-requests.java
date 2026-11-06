class Solution {
    int result ;
    int m ;
    public void solve(int i, int[] ar , int count , int[][] requests){
        if(i >= m){
            boolean isValid = true;

            for(int idx = 0 ; idx < ar.length; idx++){
                if(ar[idx] != 0){
                    isValid = false;
                    break ;
                }
            }

            if(isValid == true){
                result = Math.max(result , count );
            }

            return ;
        }


        //take the request 
        int from = requests[i][0];
        int to = requests[i][1];

        ar[from]--;
        ar[to]++;

        //explore 
        // solve(int i, int[] ar , int count , int[][] requests){
        solve(i+1 , ar , count + 1 , requests);

        //not take the request 

        ar[from]++;
        ar[to]--;

        //explore
        solve(i+1 , ar , count , requests);


    }
    public int maximumRequests(int n, int[][] requests) {
        m = requests.length;
        int[] ar = new int[n];        

        int idx = 0 ;
        int count = 0 ; // recursion call specific answer 
        result = 0 ;    //global ans 

        solve(idx , ar , count ,  requests);

        return result ;
    }
}