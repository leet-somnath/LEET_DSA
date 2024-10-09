package grid;
class Solution {
    public void dfs(int[][] arr, int node, boolean[] vis) {
        vis[node] = true;
        for (int i = 0; i < arr[node].length; i++) {
            if (arr[node][i] == 1 && !vis[i]) {
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