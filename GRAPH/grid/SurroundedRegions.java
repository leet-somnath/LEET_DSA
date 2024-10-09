import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    
    // Direction vectors for traversing up, down, left, and right
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        // Traverse the boundary of the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Apply BFS for 'O's on the boundary
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && board[i][j] == 'O') {
                    bfs(board, visited, i, j, rows, cols);
                }
            }
        }
        
        // Flip unvisited 'O's to 'X' and leave visited 'O's unchanged
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private static void bfs(char[][] board, boolean[][] visited, int x, int y, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0], curY = current[1];
            
            // Explore all 4 possible directions
            for (int k = 0; k < 4; k++) {
                int newX = curX + dx[k];
                int newY = curY + dy[k];
                
                // Check if new position is within bounds and is an unvisited 'O'
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && board[newX][newY] == 'O' && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }

    // Utility function to print the board
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        
        System.out.println("Original Board:");
        printBoard(board);
        
        solve(board);
        
        System.out.println("\nUpdated Board:");
        printBoard(board);
    }
}
