class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minimumPathSumUtil(0, 0, triangle, n, dp);
    }

    static int minimumPathSumUtil(int i, int j, List<List<Integer>> triangle, int n, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == n - 1) {
            return triangle.get(i).get(j);
        }
        int down = triangle.get(i).get(j) + minimumPathSumUtil(i + 1, j, triangle, n, dp);
        int diagonal = triangle.get(i).get(j) + minimumPathSumUtil(i + 1, j + 1, triangle, n, dp);
        return dp[i][j] = Math.min(down, diagonal);
    }
}
