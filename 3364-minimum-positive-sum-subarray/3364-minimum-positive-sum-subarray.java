class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int left = 0 ;
        int right = l -1 ;

        //constructing a prefix array 
        int[] prefix = new int[n];
        prefix[0] = nums.get(0);

        for(int i = 1 ; i < n; i++){
            prefix[i] = nums.get(i) + prefix[i-1];
        }

        int minSum = (int)1e9;

        while(right < n){

            if((right - left + 1)>= l && (right - left + 1) <= r){
                //this subarray is valid 
                int curSum = 0 ;
                if(left > 0){
                    curSum = prefix[right] - prefix[left - 1];
                }
                else if(left == 0){ //edge case 
                    curSum = prefix[right] - 0;
                }
                if(curSum > 0){
                     minSum = Math.min(curSum , minSum);
                }
                right++;
                if(right == n){
                    left++;
                    right = left + l - 1;
                }
            }
            else{
                left++;
                right = left + l - 1;
            }
        }

        return minSum==(int)1e9?-1 : minSum;

    }
}