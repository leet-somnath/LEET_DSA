


import java.util.*;

public class SearchInSOrtedROwwiseAndCOlwise {
    public static boolean searchElement(ArrayList<ArrayList<Integer>> matrix, int target) {
        int n = matrix.size();
        int m = matrix.get(0).size();
        int row = 0, col = m - 1;

        //traverse the matrix from (0, m-1):
        while (row < n && col >= 0) {
            if (matrix.get(row).get(col) == target) return true;
            else if (matrix.get(row).get(col) < target) row++;
            else col--;
        }
        return false;
        /*
         * class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int m = matrix.length; int n = matrix[0].length;
        int i=0; int j=matrix[0].length-1;
        while(i<matrix.length && j>=0){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
         */
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 4, 7, 11, 15)));
        matrix.add(new ArrayList<>(Arrays.asList(2, 5, 8, 12, 19)));
        matrix.add(new ArrayList<>(Arrays.asList(3, 6, 9, 16, 22)));
        matrix.add(new ArrayList<>(Arrays.asList(10, 13, 14, 17, 24)));
        matrix.add(new ArrayList<>(Arrays.asList(18, 21, 23, 26, 30)));

        boolean result = searchElement(matrix, 8);
        System.out.println(result ? "true" : "false");
    }
}


