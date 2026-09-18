class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0 ;
        int r = n-1;
        int ans = Integer.MIN_VALUE;

        while(l < r){
            int mini = Math.min(height[l] , height[r]);
            int area = mini * (r-l);
            ans = Math.max(area , ans);
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }
}