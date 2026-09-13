class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        int n = img1.length;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ;j++){
                if(img1[i][j] == 1){
                    a.add(new int[]{i,j});
                }

                if(img2[i][j] == 1){
                    b.add(new int[]{i,j});
                }
            }
        }

        Map<String,Integer> map = new HashMap<>();
        int ans = 0 ;

        for(int[] x : a){
            int x1 = x[0];
            int y1 = x[1];

            for(int[] y : b){
                int x2 = y[0];
                int y2 = y[1];

                int rowDif = x2 - x1;
                int colDif = y2 - y1;

                String key = rowDif + "," + colDif;

               
                    map.put(key , map.getOrDefault(key , 0)+1);
                
                

                ans = Math.max(ans , map.get(key));
            }  
        }

        return ans ;
    }
}