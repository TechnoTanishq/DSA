class Solution {
    int[][] cost, dp;
    int n;
    final int INF = 1000000;

    public int getCost(String s, int start, int end) {
        int len = end - start + 1;
        int ans = INF;

        for (int d = 1; d < len; d++) {
            if (len % d != 0) continue;

            int changes = 0;

            for (int i = 0; i < d; i++) {
                int left = start + i;
                int right = start + i + (len / d - 1) * d;

                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        changes++;
                    }
                    left += d;
                    right -= d;
                }
            }

            ans = Math.min(ans, changes);
        }

        return ans;
    }

    public int solve(int idx, int k) {
        if (k == 0) {
            return idx == n ? 0 : INF;
        }

        if (n - idx < 2 * k) return INF;

        if (dp[idx][k] != -1) return dp[idx][k];

        int ans = INF;

        for (int end = idx + 1; end <= n - 2 * (k - 1) - 1; end++) {
            int take = cost[idx][end] + solve(end + 1, k - 1);
            ans = Math.min(ans, take);
        }

        return dp[idx][k] = ans;
    }

    public int minimumChanges(String s, int k) {
        n = s.length();

        cost = new int[n][n];
        dp = new int[n][k + 1];

        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getCost(s, i, j);
            }
        }

        return solve(0, k);
    }
}