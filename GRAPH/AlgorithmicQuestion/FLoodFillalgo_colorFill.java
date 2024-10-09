import java.util.*;

class FLoodFillalgo_colorFill {
    
    // BFS function for Flood Fill
    private void bfs(int sr, int sc, int[][] ans, int[][] image, int newColor, int[] delRow, int[] delCol, int iniColor) {
        int n = image.length;
        int m = image[0].length;
        
        // Initialize the queue and mark the starting pixel
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        ans[sr][sc] = newColor;

        // BFS traversal
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            // Explore the four neighbors (up, down, left, right)
            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                // Check for valid coordinate and if the pixel is of the initial color and not yet visited (colored)
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                    && image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor) {
                    ans[nrow][ncol] = newColor;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int iniColor = image[sr][sc]; // Get the initial color
        int[][] ans = image; // Answer grid
        int[] delRow = {-1, 0, +1, 0}; // Directions for row movement (up, down)
        int[] delCol = {0, +1, 0, -1}; // Directions for column movement (left, right)

        if (iniColor != newColor) { // Only perform BFS if the color is actually changing
            bfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        Solution obj = new Solution();
        int[][] ans = obj.floodFill(image, 1, 1, 2);

        // Printing the result
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Helper class to store the coordinates as pairs
class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
