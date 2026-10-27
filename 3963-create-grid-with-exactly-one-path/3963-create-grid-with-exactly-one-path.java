class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];

        for(int i = 0 ; i < m-1 ; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(".");
            for(int j = 1 ; j < n; j++){
                sb.append("#");
            }
            ans[i] = sb.toString();
        }

        //add the final left to right path
        StringBuilder empty = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            empty.append(".");
        }

        ans[m-1] = empty.toString();

        return ans ;


    }
}