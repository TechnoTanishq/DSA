class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int counter  = 0 ;
        int[] freq = new int[3];
        int l = 0 ;

        for(int r = 0 ; r < n ; r++){
            char ch = s.charAt(r);
            freq[ch - 'a']++;

            while(freq[0] > 0 && freq[1]>0 && freq[2]>0){
                counter = counter + (n-r);
                freq[s.charAt(l) - 'a']--;
                l++;
            }
        }

        return counter;
    }
}