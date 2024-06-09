import java.util.Scanner;

public class ImageFLip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] image = new int[n][m];

        // Input the image matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                image[i][j] = scanner.nextInt();
            }
        }

        // Flip the image horizontally
        flipHorizontally(image);

        // Invert the image
        invertImage(image);

        // Output the resulting image
        printImage(image);
    }

    private static void flipHorizontally(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int left = 0, right = image[i].length - 1;
            while (left < right) {
                int temp = image[i][left];
                image[i][left] = image[i][right];
                image[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    private static void invertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                image[i][j] = image[i][j] == 0 ? 1 : 0;
            }
        }
    }

    private static void printImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
