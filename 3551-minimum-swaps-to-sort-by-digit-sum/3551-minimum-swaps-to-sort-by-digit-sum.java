class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        Integer[] sorted = new Integer[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ;i++){
            sorted[i] = nums[i];
            map.put(nums[i] , i);
        }   

        //main sorting logic 
        Arrays.sort( sorted , (a,b) -> {
            int sumA = digitSum(a);
            int sumB = digitSum(b);

            if(sumA != sumB){
                return sumA - sumB;
            }

            return a - b ;
        });


        //logic to find the swaps 
        int swaps = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] != sorted[i]){
                swaps++;

                int correctIndex = map.get(sorted[i]);
                int cur = nums[i];

                nums[i] = nums[correctIndex];
                nums[correctIndex] = cur;

                map.put(nums[correctIndex] , correctIndex);
                map.put(nums[i] , i); 
            }
        }

        return swaps ;


    }

    public int digitSum(int num){
        int sum = 0 ;
        while(num > 0){
            sum = sum + num%10;
            num = num / 10 ;
        }

        return sum ;
    }
}