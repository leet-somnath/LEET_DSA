import java.util.ArrayList;
import java.util.Scanner;

public class FirstNegativeNumberInSubarrayOfSizeK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();

        firstNegativeNumberInSubarrayOfSizeK(arr, k);
    }

    public static void firstNegativeNumberInSubarrayOfSizeK(int arr[], int k) {
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
    
        while (j < arr.length) {
            if (arr[j] < 0) {
                ans.add(arr[j]);
            }
    
            if (j - i + 1 == k) {
                if (ans.size() == 0) {
                    System.out.print("0 "); // Print 0 if no negative number found
                } else {
                    System.out.print(ans.get(0) + " "); // Print the first negative number
                    if (arr[i] == ans.get(0)) {
                        ans.remove(0);
                    }
                }
                i++;
            }
            j++;
        }
    }
    
}
