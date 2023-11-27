import java.util.*;
import java.io.*;

class MyCmp implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return a % 2 - b % 2;
    }
}

public class FirstEvenThenOddSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer arr[] = { 1, 2, 3, 4 };
        Arrays.sort(arr, new MyCmp());
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}