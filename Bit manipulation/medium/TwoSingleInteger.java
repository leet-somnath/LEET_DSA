import java.util.*;

public class TwoSingleInteger {

    public static void findNumbers(int[] arr, int N) {
        int xor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor ^= arr[i];
        }

        int rightmostSetBit = xor & -xor; // Get rightmost set bit
        // -xor == 2nd complement of the xor

        int x = 0, y = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightmostSetBit) != 0) {
                x ^= arr[i]; // XOR of elements having the rightmost set bit
            } else {
                y ^= arr[i]; // XOR of elements not having the rightmost set bit
            }
        }

        if (x < y) {
            System.out.println(x + " " + y);
        } else {
            System.out.println(y + " " + x);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2, 1, 4 };
        int N = 2;
        findNumbers(arr, N);
    }
}
