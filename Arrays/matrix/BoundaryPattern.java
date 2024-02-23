import java.util.ArrayList;

class BoundaryPattern {
    static ArrayList<Integer> boundaryTraversal(int arr[][], int n, int m) {
        ArrayList<Integer> result = new ArrayList<>();

        if (n == 1) {
            for (int i = 0; i < m; i++) {
                result.add(arr[0][i]);
            }
        } else if (m == 1) {
            for (int i = 0; i < n; i++) {
                result.add(arr[i][0]);
            }
        } else {
            for (int i = 0; i < m; i++) {
                result.add(arr[0][i]);
            }
            for (int i = 1; i < n; i++) {
                result.add(arr[i][m - 1]);
            }
            for (int i = m - 2; i >= 0; i--) {
                result.add(arr[n - 1][i]);
            }
            for (int i = n - 2; i >= 1; i--) {
                result.add(arr[i][0]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        int n = 3;
        int m = 4;

        ArrayList<Integer> result = boundaryTraversal(arr, n, m);
        System.out.println(result);
    }
}
