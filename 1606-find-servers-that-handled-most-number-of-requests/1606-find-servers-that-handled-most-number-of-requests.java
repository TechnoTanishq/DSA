
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> available = new TreeSet<>();

        // Stores {completionTime, serverId}
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] count = new int[k];

        // Initially, all servers are available
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {

            // Step 1: Release servers whose requests are completed
            while (!busy.isEmpty() &&
                   busy.peek()[0] <= arrival[i]) {

                int[] completed = busy.poll();
                available.add(completed[1]);
            }

            // Step 2: Find preferred server
            int preferred = i % k;

            Integer server = available.ceiling(preferred);

            // Step 3: Wrap around if necessary
            if (server == null && !available.isEmpty()) {
                server = available.first();
            }

            // Step 4: Drop request if no server is available
            if (server == null) {
                continue;
            }

            // Step 5: Assign request
            available.remove(server);

            count[server]++;

            int completionTime = arrival[i] + load[i];

            busy.offer(new int[]{completionTime, server});
        }

        // Step 6: Find maximum number of handled requests
        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        // Step 7: Collect busiest servers
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}
