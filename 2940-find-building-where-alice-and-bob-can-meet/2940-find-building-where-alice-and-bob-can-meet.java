class Solution {
    int n;
    int[] segTree;

    public void buildSegTree(int i, int left, int right, int[] segTree, int[] heights) {
        if (left == right) {
            segTree[i] = left;
            return;
        }

        int mid = (left + right) / 2;

        buildSegTree(2*i+1, left, mid, segTree, heights);
        buildSegTree(2*i+2, mid+1, right, segTree, heights);

        int leftMaxIdx = segTree[2*i+1];
        int rightMaxIdx = segTree[2*i+2];

        if (heights[leftMaxIdx] >= heights[rightMaxIdx]) {
            segTree[i] = leftMaxIdx;
        }
        else {
            segTree[i] = rightMaxIdx;
        }
    }

    // RMIQ(start , end , left , mid , segTree);
    public int RMIQ(int start, int end, int i, int left, int right, int[] segTree, int[] heights) {
        if (left > end || right < start) {
            return -1;
        }

        if (left >= start && right <= end) {
            return segTree[i];
        }

        int mid = (left + right) / 2;

        int leftMaxIdx = RMIQ(start, end, 2*i+1, left, mid, segTree, heights);
        int rightMaxIdx = RMIQ(start, end, 2*i+2, mid+1, right, segTree, heights);

        if (leftMaxIdx == -1) return rightMaxIdx;
        if (rightMaxIdx == -1) return leftMaxIdx;

        if (heights[leftMaxIdx] >= heights[rightMaxIdx]) {
            return leftMaxIdx;
        }
        else {
            return rightMaxIdx;
        }
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        n = heights.length;

        //building the segment tree
        segTree = new int[4*n];

        buildSegTree(0, 0, n-1, segTree, heights);

        ArrayList<Integer> ansList = new ArrayList<>();

        //processing each query
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];

            int maxIdx = Math.max(start, end); //right side idx
            int minIdx = Math.min(start, end); //left side idx

            if (start == end) {
                ansList.add(start); //they are already on the same building
            }
            else if (heights[maxIdx] > heights[minIdx]) {
                ansList.add(maxIdx);
            }
            else {
                //need to do the RMIQ on the remaining forward array using binary search
                int left = maxIdx + 1;
                int right = n-1;

                int ans_idx = -1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    int idx = RMIQ(left, mid, 0, 0, n-1, segTree, heights);

                    if (idx != -1 && heights[idx] > Math.max(heights[start], heights[end])) {
                        //this can be the answer
                        ans_idx = idx;
                        //move left
                        right = mid-1;
                    }
                    else {
                        left = mid + 1;
                    }
                }//end of while

                ansList.add(ans_idx);
            }
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            res[i] = ansList.get(i);
        }

        return res;
    }
}