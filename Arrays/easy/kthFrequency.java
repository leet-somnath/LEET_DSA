/**
 * The kthFrequency class reads an array of integers and
 *  prints the elements that occur more than n/k times, where n is the size of the array and k is a given integer.
 */
package Arrays.easy;

import java.util.*;

public class kthFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // reading
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        // getting frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // printing if frequency is > n/k itmes
        for (int i : arr) {
            if (map.get(i) > (n / k))
                System.out.println(i);
        }
    }
}