class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int flowers) {
        
        int n = flowerbed.length;
        if (n == 1) {
    if (flowerbed[0] == 0) return flowers <= 1;
    return flowers == 0;
}
        if(n==1 && flowerbed[0]==1 && flowers==0)return true;
        if(n==1 && flowerbed[0]==1 && flowers >=1)return false;
        
        if(n==1 && flowerbed[0]==0 && flowers ==0)return true;
        if(n==1 && flowerbed[0]==0 && flowers >=1)return false;

        if(flowerbed[1] != 1 && flowerbed[0]==0){
            //we can place at 0
            flowerbed[0] = 1;
            flowers--;
            if(flowers<=0)return true;
        }

        for(int i = 1 ; i < n-1 ; i++){
            
            if(flowerbed[i]==0){
                //check its adj sides 
                if(flowers==0)return true;
                if(flowerbed[i-1] != 1 && flowerbed[i+1]!=1){
                    flowerbed[i] = 1;
                    flowers--;
                }
            }

        }

        if(flowerbed[n-2] != 1 && flowerbed[n-1]==0){
            //we can place at n-1
            flowerbed[n-1] = 1;
            flowers--;
        }

        return flowers<=0;
    }
}