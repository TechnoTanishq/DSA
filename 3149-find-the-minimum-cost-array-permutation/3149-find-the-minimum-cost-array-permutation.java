
import java.util.*;

class Solution {

    private int minScore = Integer.MAX_VALUE;
    private int[] result;

    public int[] findPermutation(int[] nums) {

        int n = nums.length;

        minScore = Integer.MAX_VALUE;
        result = new int[n];

        boolean[] visited = new boolean[n];
        List<Integer> currentPerm = new ArrayList<>();

        currentPerm.add(0);
        visited[0] = true;

        solve(nums, visited, currentPerm, 0);

        return result;
    }

    private void solve(int[] nums, boolean[] visited,
                       List<Integer> currentPerm, int currentScore) {

        if (currentScore >= minScore) return;

        int n = nums.length;

        if (currentPerm.size() == n) {

            int last = currentPerm.get(n - 1);

            int score = currentScore +
                        Math.abs(last - nums[currentPerm.get(0)]);

            if (score < minScore) {

                minScore = score;

                for (int i = 0; i < n; i++) {
                    result[i] = currentPerm.get(i);
                }
            }

            return;
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                visited[i] = true;
                currentPerm.add(i);

                int prev = currentPerm.get(currentPerm.size() - 2);

                int addedScore = Math.abs(prev - nums[i]);

                solve(nums, visited, currentPerm,
                      currentScore + addedScore);

                // Backtracking
                currentPerm.remove(currentPerm.size() - 1);
                visited[i] = false;
            }
        }
    }
}
