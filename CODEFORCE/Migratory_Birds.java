import java.util.*;
import java.io.*;

public class Migratory_Birds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        migratoryBirds(arr);
        sc.close();
    }

    public static void migratoryBirds(List<Integer> arr) {
        // Write your code here
        int[] countArray = new int[5 - 1 + 1];

        arr.forEach(e -> {
            countArray[e - 1]++;
        });
        System.out.println(Arrays.toString(countArray));
        for (int i : arr) {
            System.out.println(i);
            
        }
    }

}