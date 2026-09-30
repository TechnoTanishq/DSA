class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int depth = 0 ; 
        int n = seq.length();

        int[] ans = new int[n];
        for(int i = 0 ; i < seq.length() ; i++){
            if(seq.charAt(i) == '('){
                ans[i] = depth%2;
                depth++;
            }
            else{
                depth--;
                ans[i] = depth%2;
            }
        }

        return ans;
    }
}