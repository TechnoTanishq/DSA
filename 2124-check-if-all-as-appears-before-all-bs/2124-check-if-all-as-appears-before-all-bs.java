class Solution {
    public boolean checkString(String s) {
      int n = s.length();

      int lastA = -1 ;
      int firstB = -1 ;

      //finding the last a 
      for(int i = n-1 ; i >= 0 ; i--){
        if(s.charAt(i) == 'a'){
            lastA = i;
            break;
        }
      }   


      for(int i = 0 ; i < n;  i++){
        if(s.charAt(i) == 'b'){
            firstB = i;
            break;
        }
      }

     if(lastA == -1 || firstB==-1)return true;
     
      if(lastA < firstB){
        return true;
      }

      return false;
    }
}