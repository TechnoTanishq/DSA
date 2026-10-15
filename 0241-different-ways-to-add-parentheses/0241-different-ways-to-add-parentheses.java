class Solution {


    public List<Integer> solve(String str) {
    
       List<Integer> ans = new ArrayList<>();

        for(int idx = 0 ; idx < str.length() ; idx++){

            if(str.charAt(idx) == '+' || str.charAt(idx) == '-' || str.charAt(idx) == '*'){

                  List<Integer> left = solve(str.substring(0, idx));
                  List<Integer> right = solve(str.substring(idx+1));

                 

                    for(int i = 0 ; i < left.size() ; i++){
                        for(int j = 0 ; j < right.size() ; j++){
                         
                            if(str.charAt(idx) == '+'){
                                ans.add(left.get(i) + right.get(j));
                            }
                            else if(str.charAt(idx) == '-'){
                                ans.add(left.get(i) - right.get(j));
                            }
                            else if(str.charAt(idx) == '*'){
                                ans.add(left.get(i) * right.get(j));
                            }
                        }
                    }
            }
        }

        
      if(ans.size() == 0){
        ans.add(Integer.parseInt(str));
      }


      return ans ; 



    }

    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }
}