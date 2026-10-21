class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        if (n == 2) return -1;
        
        char mn = s.charAt(0), mx = s.charAt(0);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) < mn) mn = s.charAt(i);
            if (s.charAt(i) > mx) mx = s.charAt(i);
        }
        
        // 1 operation if the minimum is at the start or maximum is at the end
        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) return 1;
        
        // 2 operations if min or max is in the interior
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == mn || s.charAt(i) == mx) return 2;
        }
        
        // Otherwise 3 operations
        return 3;
    }
}