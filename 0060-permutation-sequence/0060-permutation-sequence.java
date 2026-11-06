class Solution {

    String result;

    HashSet<Integer> set;

    int kth;

    public void solve(int n, StringBuilder sb){

        if(sb.length() == n){

            if(kth == 0){
                result = sb.toString();
                return;
            }

            kth--;
            return;
        }

        for(int i = 1 ; i <= n ; i++){

            if(result != null) return;

            if(set.contains(i)) continue;

            sb.append(i);
            set.add(i);

            solve(n, sb);

            sb.deleteCharAt(sb.length()-1);
            set.remove(i);
        }
    }

    public String getPermutation(int n, int k) {

        StringBuilder sb = new StringBuilder();

        kth = k - 1;

        result = null;

        set = new HashSet<>();

        solve(n, sb);

        return result;
    }
}