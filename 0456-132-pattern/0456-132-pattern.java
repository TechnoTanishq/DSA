class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int num3 = Integer.MIN_VALUE;
        Stack<Integer> st  = new Stack<>();

        for(int i = n-1 ; i>= 0 ; i--){
            if(nums[i] < num3){
                return true;
            }

            while(!st.isEmpty() && nums[i] > st.peek()){
                num3 = st.pop();
            }

            st.push(nums[i]);
        }

        return false;
    }
}