import java.io.*;
import java.util.*;

public class LongestSubArrayWithEqualNoOf0and1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println(findMaxLength(arr));
        }
    }

    public static int findMaxLength(int[] nums) {
        int maxLen = 0;
        int sum = 0;
        Map<Integer, Integer> sumIndices = new HashMap<>();
        sumIndices.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if (sumIndices.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - sumIndices.get(sum));
            } else {
                sumIndices.put(sum, i);
            }
        }

        return maxLen;
    }
}
