class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] < 0){
                nums[i] = nums[i] * -1;
            }
        }
        Arrays.sort(nums);
        long ans = 0L;

        int oddCount = 0 ;
        int evenCount = 0 ;

        if(n%2==0){
            oddCount = n/2;
            evenCount = n/2;
        }
        else{
            oddCount = n/2;
            evenCount = n - oddCount;
        }

        long negVal = 0;
        long posVal = 0;


        for(int i = 0 ; i < oddCount ; i++ ){
            negVal = negVal + (nums[i] * nums[i]);
        }

        for(int i = oddCount ; i < n ; i++){
            posVal += (nums[i] * nums[i]);
        }

        ans = posVal - negVal;

        return ans ;

    }
}