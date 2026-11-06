class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int sz = queries.length;
        int[] ans = new int[sz];

        Arrays.sort(logs, (a,b) -> Integer.compare(a[1], b[1]));

        Integer[] indices = new Integer[sz];

        for(int i = 0; i < sz; i++){
            indices[i] = i;
        }

        Arrays.sort(indices, (a,b) -> Integer.compare(queries[a], queries[b]));

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int distinct = 0;

        for(int i = 0; i < sz; i++){

            int idx = indices[i];

            int start = queries[idx] - x;
            int end = queries[idx];

            // Add logs within the current window
            while(right < logs.length && logs[right][1] <= end){

                int server = logs[right][0];

                map.put(server, map.getOrDefault(server, 0) + 1);

                if(map.get(server) == 1){
                    distinct++;
                }

                right++;
            }

            // Remove logs outside the current window
            while(left < right && logs[left][1] < start){

                int server = logs[left][0];

                map.put(server, map.get(server) - 1);

                if(map.get(server) == 0){
                    map.remove(server);
                    distinct--;
                }

                left++;
            }

            ans[idx] = n - distinct;
        }

        return ans;
    }
}