import java.util.*;

class Solution {
    List<Integer>[] adj;
    int[] parent, depth, heavy, head, pos, sz;
    int curPos;
    int[] tree;
    char[] chars;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        chars = s.toCharArray();

        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        sz = new int[n];
        Arrays.fill(heavy, -1);

        dfs1(0, -1, 0);
        curPos = 0;
        dfs2(0, 0);

        tree = new int[4 * n];
        for (int i = 0; i < n; i++) {
            updateTree(1, 0, n - 1, pos[i], 1 << (chars[i] - 'a'));
        }

        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                if (chars[u] != c) {
                    chars[u] = c;
                    updateTree(1, 0, n - 1, pos[u], 1 << (c - 'a'));
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int mask = queryPath(u, v, n);
                ans.add((mask & (mask - 1)) == 0);
            }
        }
        return ans;
    }

    private void dfs1(int u, int p, int d) {
        parent[u] = p;
        depth[u] = d;
        sz[u] = 1;
        int maxSub = 0;
        for (int v : adj[u]) {
            if (v != p) {
                dfs1(v, u, d + 1);
                sz[u] += sz[v];
                if (sz[v] > maxSub) {
                    maxSub = sz[v];
                    heavy[u] = v;
                }
            }
        }
    }

    private void dfs2(int u, int h) {
        head[u] = h;
        pos[u] = curPos++;
        if (heavy[u] != -1) {
            dfs2(heavy[u], h);
        }
        for (int v : adj[u]) {
            if (v != parent[u] && v != heavy[u]) {
                dfs2(v, v);
            }
        }
    }

    private void updateTree(int node, int start, int end, int idx, int mask) {
        if (start == end) {
            tree[node] = mask;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) {
            updateTree(2 * node, start, mid, idx, mask);
        } else {
            updateTree(2 * node + 1, mid + 1, end, idx, mask);
        }
        tree[node] = tree[2 * node] ^ tree[2 * node + 1];
    }

    private int queryTree(int node, int start, int end, int L, int R) {
        if (R < start || end < L) return 0;
        if (L <= start && end <= R) return tree[node];
        int mid = (start + end) / 2;
        return queryTree(2 * node, start, mid, L, R) ^ queryTree(2 * node + 1, mid + 1, end, L, R);
    }

    private int queryPath(int u, int v, int n) {
        int res = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u; u = v; v = temp;
            }
            res ^= queryTree(1, 0, n - 1, pos[head[u]], pos[u]);
            u = parent[head[u]];
        }
        if (depth[u] > depth[v]) {
            int temp = u; u = v; v = temp;
        }
        res ^= queryTree(1, 0, n - 1, pos[u], pos[v]);
        return res;
    }
}