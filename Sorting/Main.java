import java.util.*;

public class Main {
    public static void main(String[] args) {
        int arr[] = {1, 3, 1};
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }
}