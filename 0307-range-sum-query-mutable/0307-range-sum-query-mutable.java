class NumArray {
    int[] segmentTree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, nums); // Build the segment tree
    }

    private void buildSegmentTree(int i, int left, int right, int[] nums) {
        if (left == right) {
            segmentTree[i] = nums[left];
            return;
        }
        int mid = left + (right - left) / 2;
        buildSegmentTree(2 * i + 1, left, mid, nums);
        buildSegmentTree(2 * i + 2, mid + 1, right, nums);
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    public void update(int index, int val) {
        updateST(index, val, 0, 0, n - 1);
    }

    private void updateST(int index, int val, int i, int left, int right) {
        if (left == right) {
            segmentTree[i] = val;
            return;
        }
        int mid = left + (right - left) / 2;
        if (index <= mid) {
            updateST(index, val, 2 * i + 1, left, mid);
        } else {
            updateST(index, val, 2 * i + 2, mid + 1, right);
        }
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    public int sumRange(int left, int right) {
        return querySum(0, 0, n - 1, left, right);
    }

    private int querySum(int i, int left, int right, int qLeft, int qRight) {
       
        if (qLeft > right || qRight < left) {
            return 0;
        }
     
        if (qLeft <= left && qRight >= right) {
            return segmentTree[i];
        }
       
        int mid = left + (right - left) / 2;
        int leftSum = querySum(2 * i + 1, left, mid, qLeft, qRight);
        int rightSum = querySum(2 * i + 2, mid + 1, right, qLeft, qRight);
        return leftSum + rightSum;
    }
}