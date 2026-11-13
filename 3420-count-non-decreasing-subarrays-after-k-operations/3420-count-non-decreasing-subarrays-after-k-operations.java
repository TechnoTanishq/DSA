import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        long ans = 0;
        long cost = 0;
        // Monotonic deque storing indices where nums[i] is in non-increasing order from front to back
        Deque<Integer> dq = new ArrayDeque<>();
        
        int j = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            final int num = nums[i];
            
            // Maintain decreasing stack/deque: pop elements smaller than current `num`
            while (!dq.isEmpty() && nums[dq.peekLast()] < num) {
                final int l = dq.pollLast();
                final int r = dq.isEmpty() ? j + 1 : dq.peekLast();
                // Add the cost to raise these elements up to `num`
                cost += (long) (r - l) * (num - nums[l]);
            }
            dq.offerLast(i);
            
            // If the cost exceeds k, shrink the window from the right (decrement j)
            while (cost > k) {
                cost -= nums[dq.peekFirst()] - nums[j];
                if (dq.peekFirst() == j) {
                    dq.pollFirst();
                }
                --j;
            }
            
            // All subarrays starting at `i` and ending anywhere between `i` and `j` are valid
            ans += j - i + 1;
        }
        
        return ans;
    }
}