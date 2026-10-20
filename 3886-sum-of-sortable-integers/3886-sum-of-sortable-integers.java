class Solution {
    public boolean isSortable(int[] nums, int k) {
        int n = nums.length;
        int prevMax = Integer.MIN_VALUE;

        for (int start = 0; start < n; start += k) {
            int drops = 0;
            int dropIdx = 0;

            for (int j = 0; j < k; j++) {
                int curr = nums[start + j];
                int next = nums[start + (j + 1) % k];
                if (curr > next) {
                    drops++;
                    dropIdx = j;
                }
            }

            if (drops > 1) return false;

            // Find min and max of the block after rotation using dropIdx
            int currMin = (drops == 0) ? nums[start] : nums[start + (dropIdx + 1) % k];
            int currMax = (drops == 0) ? nums[start + k - 1] : nums[start + dropIdx];

            // Check order between adjacent blocks
            if (prevMax > currMin) return false;

            prevMax = currMax;
        }

        return true;
    }

    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k == 0 && isSortable(nums, k)) {
                ans += k;
            }
        }

        return ans;
    }
}