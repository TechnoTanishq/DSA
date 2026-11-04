
class Solution {

    class BIT {
        long[] bit;
        int n;

        BIT(int n) {
            this.n = n;
            bit = new long[n + 1];
        }

        void update(int i, long val) {
            while (i <= n) {
                bit[i] += val;
                i += i & -i;
            }
        }

        long query(int i) {
            long sum = 0;

            while (i > 0) {
                sum += bit[i];
                i -= i & -i;
            }

            return sum;
        }

        // Find smallest index having prefix sum >= target
        int kth(long target) {
            int idx = 0;

            for (int i = Integer.highestOneBit(n); i > 0; i >>= 1) {
                int next = idx + i;

                if (next <= n && bit[next] < target) {
                    idx = next;
                    target -= bit[next];
                }
            }

            return idx + 1;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

       
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int m = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                sorted[m++] = sorted[i];
            }
        }

        BIT freq = new BIT(m);
        BIT sum = new BIT(m);

        int[] id = new int[n];

        for (int i = 0; i < n; i++) {
            id[i] = Arrays.binarySearch(sorted, 0, m, nums[i]) + 1;
        }

        
        long[] cost = new long[n - x + 1];

        for (int i = 0; i < n; i++) {

            int idx = id[i];

            freq.update(idx, 1);
            sum.update(idx, nums[i]);

            if (i >= x) {
                int removeIdx = id[i - x];

                freq.update(removeIdx, -1);
                sum.update(removeIdx, -nums[i - x]);
            }

            if (i >= x - 1) {

                // Find median
                int medianIdx = freq.kth((x + 1L) / 2);
                long median = sorted[medianIdx - 1];

                // Left side: values <= median
                long leftCount = freq.query(medianIdx);
                long leftSum = sum.query(medianIdx);

                // Total elements and sum
                long totalSum = sum.query(m);
                long totalCount = x;

                // Right side: values > median
                long rightCount = totalCount - leftCount;
                long rightSum = totalSum - leftSum;

                long leftCost = median * leftCount - leftSum;
                long rightCost = rightSum - median * rightCount;

                cost[i - x + 1] = leftCost + rightCost;
            }
        }

        // DP: dp[j] = minimum cost to select j windows
        // Process windows from left to right.

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }

        for (int j = 1; j <= k; j++) {

            for (int i = 1; i <= n; i++) {

                // Do not select a window ending at i-1
                dp[j][i] = dp[j][i - 1];

                // Select window [i-x, i-1]
                if (i >= x && dp[j - 1][i - x] != INF) {

                    long take = dp[j - 1][i - x] + cost[i - x];

                    dp[j][i] = Math.min(dp[j][i], take);
                }
            }
        }

        return dp[k][n];
    }
}
