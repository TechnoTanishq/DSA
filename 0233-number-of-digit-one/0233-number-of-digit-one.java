
import java.util.Arrays;

class Solution {
    int[][][] dp;

    public int find(int index, boolean tight, int oneCount, String s) {
        if (index == s.length()) {
            return oneCount;
        }

        int tightVal = tight ? 1 : 0;

        if (dp[index][tightVal][oneCount] != -1) {
            return dp[index][tightVal][oneCount];
        }

        int ans = 0;
        int limit = tight ? s.charAt(index) - '0' : 9;

        for (int d = 0; d <= limit; d++) {
            boolean newTight =
                tight && (d == s.charAt(index) - '0');

            ans += find(
                index + 1,
                newTight,
                oneCount + (d == 1 ? 1 : 0),
                s
            );
        }

        return dp[index][tightVal][oneCount] = ans;
    }

    public void initializeDp() {
        dp = new int[10][2][11];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }
    }

    public int countDigitOne(int n) {
        String h = String.valueOf(n);
        initializeDp();
        return find(0, true, 0, h);
    }
}
