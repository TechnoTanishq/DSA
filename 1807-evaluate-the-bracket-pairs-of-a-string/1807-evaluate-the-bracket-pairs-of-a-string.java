class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        HashMap<String,String> map = new HashMap<>();

        for(List<String> list : knowledge){
            String key = list.get(0);
            String val = list.get(1);
            map.put(key , val);
        }

        //int start = 0 ;
        //int end = 0 ;

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);

            
            if(ch == '('){
                int start = i + 1  ;
                int end = start ;

                while(s.charAt(end) != ')'){
                    end ++ ;
                }
                String temp = s.substring(start , end );
                if(map.containsKey(temp)){
                    sb.append(map.get(temp));
                }
                else{
                    sb.append("?");
                }
                i = end  ;
            }//inner if 
            else{
            sb.append(ch);

            }

        }

        return sb.toString();
    }
}