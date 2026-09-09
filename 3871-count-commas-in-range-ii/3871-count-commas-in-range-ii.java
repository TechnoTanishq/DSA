class Solution {
    public long countCommas(long n) {
        long ans = 0 ;
        long threshold = 1000;

        while(threshold <= n){
            ans += n - threshold + 1 ;
            threshold = threshold * 1000;
        }
        return ans ;
    }
}