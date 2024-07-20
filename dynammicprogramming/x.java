<<<<<<< HEAD

import java.util.*;

class CountWaysinGridwithObstacle {
    // Helper function to calculate the number of paths through the maze
    static int mazeObstaclesUtil(int i, int j, int[][] maze, int[][] dp) {
        // If there's an obstacle at this cell or out of bounds, return 0
        if (i >= 0 && j >= 0 && maze[i][j] == -1)
            return 0;
        // If we've reached the start cell, there's one valid path
        if (i == 0 && j == 0)
            return 1;
        // If we're out of bounds, return 0
        if (i < 0 || j < 0)
            return 0;
        // If we've already calculated this cell, return the stored result
        if (dp[i][j] != -1)
            return dp[i][j];

        // Calculate the number of paths by moving up and left
        int up = mazeObstaclesUtil(i - 1, j, maze, dp);
        int left = mazeObstaclesUtil(i, j - 1, maze, dp);

        // Store the result and return it
        return dp[i][j] = up + left;
    }

    // Main function to calculate the number of paths through the maze
    static int mazeObstacles(int n, int m, int[][] maze) {
        int dp[][] = new int[n][m];
        
        // Initialize the dp array with -1
        for (int row[] : dp)
            Arrays.fill(row, -1);
        
        // Call the helper function starting from the bottom-right cell
        return mazeObstaclesUtil(n - 1, m - 1, maze, dp);
    }

    public static void main(String args[]) {
        // Define the maze
        int[][] maze = {
            {0, 0, 0},
            {0, -1, 0},
            {0, 0, 0}
        };

        int n = maze.length;
        int m = maze[0].length;

        // Calculate and print the number of paths through the maze
        System.out.println(mazeObstacles(n, m, maze));
    }
}

=======

import java.util.*;

class CountWaysinGridwithObstacle {
    // Helper function to calculate the number of paths through the maze
    static int mazeObstaclesUtil(int i, int j, int[][] maze, int[][] dp) {
        // If there's an obstacle at this cell or out of bounds, return 0
        if (i >= 0 && j >= 0 && maze[i][j] == -1)
            return 0;
        // If we've reached the start cell, there's one valid path
        if (i == 0 && j == 0)
            return 1;
        // If we're out of bounds, return 0
        if (i < 0 || j < 0)
            return 0;
        // If we've already calculated this cell, return the stored result
        if (dp[i][j] != -1)
            return dp[i][j];

        // Calculate the number of paths by moving up and left
        int up = mazeObstaclesUtil(i - 1, j, maze, dp);
        int left = mazeObstaclesUtil(i, j - 1, maze, dp);

        // Store the result and return it
        return dp[i][j] = up + left;
    }

    // Main function to calculate the number of paths through the maze
    static int mazeObstacles(int n, int m, int[][] maze) {
        int dp[][] = new int[n][m];
        
        // Initialize the dp array with -1
        for (int row[] : dp)
            Arrays.fill(row, -1);
        
        // Call the helper function starting from the bottom-right cell
        return mazeObstaclesUtil(n - 1, m - 1, maze, dp);
    }

    public static void main(String args[]) {
        // Define the maze
        int[][] maze = {
            {0, 0, 0},
            {0, -1, 0},
            {0, 0, 0}
        };

        int n = maze.length;
        int m = maze[0].length;

        // Calculate and print the number of paths through the maze
        System.out.println(mazeObstacles(n, m, maze));
    }
}

>>>>>>> 504a43f5310a405e785594a6b52cb9f857ad9822
