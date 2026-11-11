class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = 0;
        
        // Find how many items we can satisfy for both requirements simultaneously
        long bothCount = Math.min(need1, need2);
        
        // Use the cheaper option between buying a type 3 item or buying both type 1 and type 2 items
        ans += bothCount * Math.min((long)costBoth, (long)cost1 + cost2);
        
        need1 -= bothCount;
        need2 -= bothCount;
        
        // For the remaining type 1 requirement, use the cheaper option between costBoth and cost1
        if (need1 > 0) {
            ans += need1 * Math.min((long)costBoth, (long)cost1);
        }
        
        // For the remaining type 2 requirement, use the cheaper option between costBoth and cost2
        if (need2 > 0) {
            ans += need2 * Math.min((long)costBoth, (long)cost2);
        }
        
        return ans;
    }
}