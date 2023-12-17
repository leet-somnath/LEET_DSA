import java.util.*;;

public class CountingSort {

    public static void countingSort(int[] array) {
        // Find the minimum and maximum values in the array to determine the range
        int min = Arrays.stream(array).min().orElse(0);
        int max = Arrays.stream(array).max().orElse(0);

        // Create a count array to store the count of each element
        int[] countArray = new int[max - min + 1];

        // Populate the count array
        for (int value : array) {
            countArray[value - min]++;
        }
System.out.println(Arrays.toString(countArray));
        // Update the count array to store the cumulative count
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
System.out.println(Arrays.toString(countArray));
        // Create a temporary array to store the sorted result
        int[] resultArray = new int[array.length];

        // Build the result array by placing elements in their correct positions
        for (int i = array.length - 1; i >= 0; i--) {
            int value = array[i];
            System.out.println(value);
            int index = countArray[value - min] - 1;
            System.out.println(index);
            resultArray[index] = value;
            System.out.println(Arrays.toString(resultArray));
            countArray[value - min]--;
            System.out.println(Arrays.toString(countArray));
        }

        // Copy the result array back to the original array
        System.arraycopy(resultArray, 0, array, 0, array.length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
