import java.util.Arrays;

class Solution {
    private static final long MOD = 1_000_000_007L;
    private long[] tree;
    private long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        tree = new long[4 * n];
        lazy = new long[4 * n];

        // Since 1 <= nums[i] <= 10^5, an array is faster than a HashMap
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] lastPos = new int[maxVal + 1];
        Arrays.fill(lastPos, -1);

        long totalAns = 0;
        long currentSumOfSquares = 0;

        for (int r = 0; r < n; r++) {
            int val = nums[r];
            int p = lastPos[val];
            lastPos[val] = r;

            // 1. Query the current sum of distinct counts in range [p + 1, r]
            long rangeSum = query(1, 0, n - 1, p + 1, r);

            // 2. Update the running sum of squares for all subarrays ending at r:
            //    New Sum of Squares = Old Sum of Squares + 2 * rangeSum + (r - p)
            long len = r - p;
            currentSumOfSquares = (currentSumOfSquares + 2 * rangeSum + len) % MOD;

            // 3. Add the contribution of all subarrays ending at r to the total answer
            totalAns = (totalAns + currentSumOfSquares) % MOD;

            // 4. Increment distinct counts in range [p + 1, r] by 1
            update(1, 0, n - 1, p + 1, r, 1);
        }

        return (int) totalAns;
    }

    private void pushDown(int node, int start, int end) {
        if (lazy[node] != 0) {
            int mid = (start + end) >>> 1;
            int left = node << 1;
            int right = left | 1;
            long add = lazy[node];

            tree[left] = (tree[left] + add * (mid - start + 1)) % MOD;
            lazy[left] = (lazy[left] + add) % MOD;

            tree[right] = (tree[right] + add * (end - mid)) % MOD;
            lazy[right] = (lazy[right] + add) % MOD;

            lazy[node] = 0;
        }
    }

    private void update(int node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            tree[node] = (tree[node] + (long) val * (end - start + 1)) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
            return;
        }
        pushDown(node, start, end);
        int mid = (start + end) >>> 1;
        if (l <= mid) {
            update(node << 1, start, mid, l, r, val);
        }
        if (r > mid) {
            update((node << 1) | 1, mid + 1, end, l, r, val);
        }
        tree[node] = (tree[node << 1] + tree[(node << 1) | 1]) % MOD;
    }

    private long query(int node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return tree[node];
        }
        pushDown(node, start, end);
        int mid = (start + end) >>> 1;
        long sum = 0;
        if (l <= mid) {
            sum = (sum + query(node << 1, start, mid, l, r)) % MOD;
        }
        if (r > mid) {
            sum = (sum + query((node << 1) | 1, mid + 1, end, l, r)) % MOD;
        }
        return sum;
    }
}