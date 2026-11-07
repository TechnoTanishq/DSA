import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        // Available servers: [weight, index]
        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        // Busy servers: [freeTime, weight, index]
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        // Initially, all servers are free
        for (int i = 0; i < n; i++) {
            available.offer(new int[] { servers[i], i });
        }

        long currentTime = 0;

        for (int j = 0; j < m; j++) {
            currentTime = Math.max(currentTime, j);

            // Release servers whose tasks are completed by currentTime
            while (!busy.isEmpty() && busy.peek()[0] <= currentTime) {
                int[] s = busy.poll();
                available.offer(new int[] { s[1], s[2] });
            }

            // If no server is available, jump time to the next available server's completion time
            if (available.isEmpty()) {
                currentTime = busy.peek()[0];
                while (!busy.isEmpty() && busy.peek()[0] <= currentTime) {
                    int[] s = busy.poll();
                    available.offer(new int[] { s[1], s[2] });
                }
            }

            // Select the best available server
            int[] server = available.poll();
            int weight = server[0];
            int index = server[1];

            ans[j] = index;

            // Assign task and calculate completion time
            busy.offer(new int[] { (int) currentTime + tasks[j], weight, index });
        }

        return ans;
    }
}