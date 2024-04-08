import java.util.ArrayList;
import java.util.List;

public class ZigZagTraversal {

    public static List<Integer> zigzagTraversal(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        if (rows == 0) return result; // Empty matrix
        
        int cols = matrix[0].length;
        boolean isGoingDown = true;
        
        int row = 0, col = 0;
        
        while (row < rows && col < cols) {
            result.add(matrix[row][col]);
            if (isGoingDown) {
                if (col == 0 || row == rows - 1) {
                    if (row == rows - 1) {
                        col++;
                    } else {
                        row++;
                    }
                    isGoingDown = false;
                } else {
                    row++;
                    col--;
                }
            } else {
                if (row == 0 || col == cols - 1) {
                    if (col == cols - 1) {
                        row++;
                    } else {
                        col++;
                    }
                    isGoingDown = true;
                } else {
                    row--;
                    col++;
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        List<Integer> result = zigzagTraversal(matrix);
        System.out.println("Zigzag traversal: " + result);
    }
}
