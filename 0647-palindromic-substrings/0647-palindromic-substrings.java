class Solution {
    public boolean isPalindromic(String str){
        int left = 0 ;
        int right = str.length()-1;

        while(left <= right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true
        ;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0 ;
        
        for(int i = 0 ; i < n; i++){
            for(int j = i;  j < n ; j++){
                String str = s.substring( i , j+1);
                if(isPalindromic(str)){
                    count ++;
                }
            }
        }

        return count;
    }
}