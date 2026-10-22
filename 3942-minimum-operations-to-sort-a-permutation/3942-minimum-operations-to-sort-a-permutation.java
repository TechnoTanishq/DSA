class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        
        // Find the index of 0
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }
        
        // Check if elements strictly increase going clockwise (+1 step)
        boolean isClockwise = true;
        for (int i = 1; i < n; i++) {
            int prev = (zero + i - 1) % n;
            int curr = (zero + i) % n;
            if (nums[prev] > nums[curr]) {
                isClockwise = false;
                break;
            }
        }
        
        // Check if elements strictly increase going counter-clockwise (-1 step)
        boolean isCounterClockwise = true;
        for (int i = 1; i < n; i++) {
            int prev = (zero - i + 1 + n) % n;
            int curr = (zero - i + n) % n;
            if (nums[prev] > nums[curr]) {
                isCounterClockwise = false;
                break;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        if (isClockwise) {
            // Option 1: Left rotate directly
            ans = Math.min(ans, zero);
            // Option 2: Reverse -> Left rotate -> Reverse
            ans = Math.min(ans, n - zero + 2);
        }
        
        if (isCounterClockwise) {
            // Option 3: Reverse -> Left rotate
            ans = Math.min(ans, zero + 2);
            // Option 4: Left rotate -> Reverse
            ans = Math.min(ans, n - zero);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}