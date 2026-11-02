
class NumArray {

    int[] bit;
    int[] nums;
    int N;

    public NumArray(int[] nums) {
        this.N = nums.length;
        this.nums = nums.clone();
        this.bit = new int[N + 1];

        //initializing the Fenwick Tree
        for (int i = 0; i < N; i++) {
            add(i + 1, nums[i]);
        }
    }

    //adding difference to BIT
    public void add(int index, int val) {
        while (index <= N) {
            bit[index] += val;
            index += (index & (-index));
        }
    }

    public void update(int index, int val) {

        int diff = val - nums[index];

        nums[index] = val;

        add(index + 1, diff);
    }

    public int sumRange(int left, int right) {
        return sum(right + 1) - sum(left);
    }

    public int sum(int idx) {
        int ans = 0;

        while (idx > 0) {
            ans += bit[idx];
            idx -= (idx & (-idx));
        }

        return ans;
    }
}
