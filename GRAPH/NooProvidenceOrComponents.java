class Solution {
    public void dfs(int[][] arr, int curr, boolean[] vis) {
        vis[curr] = true;
        for (int i = 0; i < arr[curr].length; i++) {
            if (arr[curr][i] == 1 && !vis[i]) {
                dfs(arr, i, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!vis[i]) {
                count++;
                dfs(isConnected, i, vis);
            }
        }
        return count;
    }
}