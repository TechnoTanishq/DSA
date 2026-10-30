
import java.util.*;

class Pair {
    int node;
    int weight;
    int count;

    public Pair(int n, int w, int c) {
        this.node = n;
        this.weight = w;
        this.count = c;
    }
}

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

     //building the adj list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
        }

        //dist[node][consecutiveCount]
        int[][] dist = new int[n][k + 1];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.weight, b.weight)
        );

        //starting node has count = 1
        dist[0][1] = 0;
        pq.offer(new Pair(0, 0, 1));

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            int u = cur.node;
            int curDist = cur.weight;
            int count = cur.count;

            //ignoring the  outdated states
            if (curDist > dist[u][count]) {
                continue;
            }

            //destination reached
            if (u == n - 1) {
                return curDist;
            }

            //explore neighbours
            for (int[] edge : adj.get(u)) {

                int v = edge[0];
                int w = edge[1];

                int nextCount;

                if (labels.charAt(u) == labels.charAt(v)) {
                    nextCount = count + 1;
                } else {
                    nextCount = 1;
                }

                //invalid transition
                if (nextCount > k) {
                    continue;
                }

                int newDist = curDist + w;

                if (newDist < dist[v][nextCount]) {

                    dist[v][nextCount] = newDist;

                    pq.offer(new Pair(v, newDist, nextCount));
                }
            }
        }

        return -1;
    }
}
