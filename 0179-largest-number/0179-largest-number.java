class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ar = new String[n];

        int idx = 0 ;
        for(int num : nums){
            String temp = String.valueOf(num);
            ar[idx] = temp ;
            idx++;
        }

        Arrays.sort(ar , (a , b ) -> (b+a).compareTo(a+b));

        if(ar[0].equals("0")){
            return "0";
        }

        StringBuilder ans = new StringBuilder();

        for(String str : ar){
            ans.append(str);
        }

        return ans.toString();
    }
}