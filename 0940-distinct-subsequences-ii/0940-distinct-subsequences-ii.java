class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();

        long[] dp = new long[26];

        long total = 0;

        for(char ch : s.toCharArray()){
            int c = ch - 'a';
            long newVal = (total + 1) % 1000000007;

            //removing the duplicate 
            total = (total - dp[c] + newVal + 1000000007)%1000000007;


            dp[c] = newVal;
        }

        return (int)total;
    }
}