import java.util.*;

public class PrintingSubsequences {
    static ArrayList<Integer> arrs = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int i = 0;
        subseqgen(arr, i);
        sc.close();
    }

    public static void subseqgen(int[] arr, int i) {
        if (i == arr.length) {
            for (Integer k : arrs)
                System.out.print(k+" ");
                System.out.println();
            return;
        }

        // Include the current element
        arrs.add(arr[i]);
        subseqgen(arr, i + 1);

        // Exclude the current element
        arrs.remove(arrs.size() - 1);
        subseqgen(arr, i + 1);
    }
}
