class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //1.creating the adj list 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] ar : prerequisites){
            int p = ar[1];
            int cur = ar[0];
            adj.get(p).add(cur);
            indegree[cur]++;
        }

        //applying the Khans algorithm 
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        
        while(!q.isEmpty()){
            int cur = q.poll();
            list.add(cur);


            for(int nn : adj.get(cur)){
                indegree[nn]--;
                if(indegree[nn] == 0){
                    q.add(nn);
                }
            }
        }


        int[] ans = new int[list.size()];

        if(list.size() != numCourses){
            return new int[] {};
        }

        for(int i = 0 ; i < list.size() ; i++){
            ans[i] = list.get(i);
        }

        return ans ;

    
    }
}