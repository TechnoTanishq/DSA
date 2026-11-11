class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = 0;
        
        long bothCount = Math.min(need1, need2);
        
        ans += bothCount * Math.min((long)costBoth, (long)cost1 + cost2);
        
        need1 -= bothCount;
        need2 -= bothCount;
        
        if (need1 > 0) {
            ans += need1 * Math.min((long)costBoth, (long)cost1);
        }
        
        if (need2 > 0) {
            ans += need2 * Math.min((long)costBoth, (long)cost2);
        }
        
        return ans;
    }
}