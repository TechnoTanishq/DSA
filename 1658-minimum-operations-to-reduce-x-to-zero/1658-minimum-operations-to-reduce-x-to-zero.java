// class Solution {

//     int[][] dp;

//     public int find(int start, int end, int[] nums, int x, int n) {

//         // x = 0, no more operations needed
//         if (x == 0) {
//             return 0;
//         }

//         // x became negative
//         if (x < 0) {
//             return -1;
//         }

//         // No elements remaining
//         if (start > end) {
//             return -1;
//         }

//         // Already calculated this state
//         if (dp[start][end] != -2) {
//             return dp[start][end];
//         }

//         // Remove first element
//         int removeFirst = find(
//             start + 1, end, nums, x - nums[start], n
//         );

//         if (removeFirst != -1) {
//             removeFirst++;
//         }

//         // Remove last element
//         int removeLast = find(
//             start, end - 1, nums, x - nums[end], n
//         );

//         if (removeLast != -1) {
//             removeLast++;
//         }

//         // Both paths failed
//         if (removeFirst == -1 && removeLast == -1) {
//             return dp[start][end] = -1;
//         }

//         // One path failed
//         if (removeFirst == -1) {
//             return dp[start][end] = removeLast;
//         }

//         if (removeLast == -1) {
//             return dp[start][end] = removeFirst;
//         }

//         // Both paths succeeded
//         return dp[start][end] = Math.min(removeFirst, removeLast);
//     }

//     public int minOperations(int[] nums, int x) {

//         int n = nums.length;

//         dp = new int[n][n];

//         for (int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -2);
//         }

//         return find(0, n - 1, nums, x, n);
//     }
// }


class Solution {
   public int longestSubarrayLength(int[] nums, int req) {
    int n = nums.length;
    int left = 0;
    int right = 0;
    int sum = 0;
    int maxLen = -1;

    while (right < n) {

        sum += nums[right];

        while (left <= right && sum > req) {
            sum -= nums[left];
            left++;
        }

        if (sum == req) {
            int len = right - left + 1;
            maxLen = Math.max(len, maxLen);
        }

        right++;
    }

    return maxLen;
}

public int minOperations(int[] nums, int x) {

    int sum = 0;
    int n = nums.length;

    for (int num : nums) {
        sum += num;
    }

    int req = sum - x;

    if (req == 0) {
        return n;
    }

    if (req < 0) {
        return -1;
    }

    int maxLen = longestSubarrayLength(nums, req);

    if (maxLen == -1) {
        return -1;
    }

    return n - maxLen;
}
}