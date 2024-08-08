/*
You are given an array of size N containing unique integers. Find the size of the largest subarray that can be rearranged to form a contiguous sequence.
A contiguous sequence means that the difference of adjacent elements should be 1.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the size of the array.
The second line contains the elements of the array.

Constraints

1 <= T <= 100
1 <= N <= 1000
0 <= A[i] <= 105

Output Format

For each test case, print the size of the largest subarray that can be rearranged to form a contiguous sequence, on a new line.

Sample Input 0

2
5
1 3 2 6 5
9
0 8 6 5 7 10 3 2 1
Sample Output 0

3
4
Explanation 0

Test-Case 1
The largest subarray which can be rearranged to form a continguous sequence is [1, 3, 2], which can be rearranged to form [1, 2, 3].

Test-Case 2
The largest subarray which can be rearranged to form a continguous sequence is [8, 6, 5, 7], which can be rearranged to form [5, 6, 7, 8].


*/
import java.util.*;

public class LongestRearrangableSubarrayone {
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
