import java.util.*;
//https://leetcode.com/problems/01-matrix/
class Solution {
    class Node {
        int first;
        int second;
        int third;

        Node(int _first, int _second, int _third) {
            this.first = _first;
            this.second = _second;
            this.third = _third;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Visited and distance matrices
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];

        // Queue for BFS <coordinates, steps>
        Queue<Node> q = new LinkedList<>();

        // Traverse the matrix to initialize BFS with all 0s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Node(i, j, 0)); // Add 0 cells to the queue
                    vis[i][j] = 1; // Mark as visited
                } else {
                    vis[i][j] = 0; // Mark cells with 1 as unvisited
                }
            }
        }

        // Direction vectors for the 4 neighbors (up, right, down, left)
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        // BFS traversal
        while (!q.isEmpty()) {
            Node node = q.poll();
            int row = node.first;
            int col = node.second;
            int steps = node.third;

            // Update the distance for the current cell
            dist[row][col] = steps;

            // Explore all 4 neighbors
            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                // Check if the new position is valid and unvisited
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0) {
                    vis[nRow][nCol] = 1; // Mark as visited
                    q.add(new Node(nRow, nCol, steps + 1)); // Add new position to queue
                }
            }
        }

        // Return the distance matrix
        return dist;
    }
}
