class Solution {
    public int maxElement(int mat[][], int row, int n, int m) {
        int maxi = 0, idx = -1;

        for (int i = 0; i < n; i++) {
            if (mat[i][row] > maxi) {
                maxi = mat[i][row];
                idx = i;
            }
        }
        return idx;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = m-1;

        while (low <= high) {
            int mid = low+(high-low)/2;
            int maxi = maxElement(mat, mid, n, m);
            int left = (mid > 0) ? mat[maxi][mid-1] : -1;
            int right = (mid < m-1) ? mat[maxi][mid+1] : -1;

            if (mat[maxi][mid] > left && mat[maxi][mid] > right) {
                int res[] = new int[2];
                res[0] = maxi;
                res[1] = mid;
                return res;
            } else if (left > mat[maxi][mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return null;
    }
}