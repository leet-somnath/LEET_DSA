import java.util.*;

public class LeaderArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the size of the array
        int n = sc.nextInt();

        // Input the array elements
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Finding leaders in the array
        List<Integer> leaders = new ArrayList<>();
        int maxRight = arr[n - 1];
        leaders.add(maxRight);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxRight) {
                maxRight = arr[i];
                leaders.add(maxRight);
            }
        }

        // Display the leaders
        Collections.reverse(leaders);
        System.out.println("Leaders in the array: " + leaders);

        sc.close();
    }
}
