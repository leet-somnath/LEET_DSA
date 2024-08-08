import java.util.*;

public class LongestConsectiveSubsequence {
    public static int findLongestConseqSubseq(int[] arr, int n) {
        Set<Integer> s = new HashSet<>();
        int ans = 0;

        // Add all elements to the HashSet
        for (int num : arr) {
            s.add(num);
        }

        // Iterate over each element in the array
        for (int num : arr) {
            // Check if it's the start of a sequence
            if (!s.contains(num - 1)) {
                int j = num;
                
                // Count the length of the sequence
                while (s.contains(j)) {
                    j++;
                }
                
                // Update the maximum length
                ans = Math.max(ans, j - num);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(findLongestConseqSubseq(arr, n));
        }

        sc.close();
    }
}
