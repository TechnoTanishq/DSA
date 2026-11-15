// Brute Force - Gives tle fo rthe 139 / 151 testcaases 

// class Solution {
//     public int numOfSubarrays(int[] arr) {
//         int n = arr.length;
//         int count = 0 ;

//         for(int i = 0 ; i < n ; i++){
//             int sum = 0 ;
//             for(int j = i ;j < n; j++){
//                 sum += arr[j];
//                 if(sum%2==1){
//                     count++;
//                 }
//             }
//         }

//         return count ;
//     }
// }


//optimal solution 

class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;

        int even = 1; // Empty prefix sum is even
        int odd = 0;

        int prefixSum = 0;
        int count = 0;

        for(int num : arr) {
            prefixSum += num;

            if(prefixSum % 2 == 0) {
                count += odd;
                even++;
            }
            else {
                count += even;
                odd++;
            }

            count %= mod;
        }

        return count;
    }
}
