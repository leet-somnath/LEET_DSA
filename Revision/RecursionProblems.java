import java.util.*;

public class RecursionProblems {

    // Problem 1: Reverse a String
    public static String reverseString(String s) {
        if (s.isEmpty()) return s;
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    // Problem 2: Palindrome Check
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        return s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1));
    }

    // Problem 3: Factorial
    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    // Problem 4: Fibonacci Series
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Problem 5: Power Function
    public static double power(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) return 1 / power(x, -n);
        double half = power(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }

    // Problem 6: Merge Sort
    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (i = left, k = 0; i <= right; i++, k++) {
            nums[i] = temp[k];
        }
    }

    // Problem 7: Binary Search
    public static int binarySearch(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private static int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) return binarySearch(nums, target, mid + 1, right);
        return binarySearch(nums, target, left, mid - 1);
    }

    // Problem 8: Permutations
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    private static void permute(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length - 1) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
        } else {
            for (int i = index; i < nums.length; i++) {
                swap(nums, index, i);
                permute(nums, index + 1, result);
                swap(nums, index, i);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Problem 9: Subsets
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void subsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            subsets(nums, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    // Problem 10: Combination Sum
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void combinationSum(int[] candidates, int target, int index, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                combination.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], i, combination, result);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        // Test each problem here
        String str = "hello";
        System.out.println("Problem 1: Reverse a String: " + reverseString(str));

        String palindrome = "racecar";
        System.out.println("Problem 2: Palindrome Check: " + isPalindrome(palindrome));

        int n = 5;
        System.out.println("Problem 3: Factorial of " + n + ": " + factorial(n));

        int fib = 6;
        System.out.println("Problem 4: Fibonacci of " + fib + ": " + fibonacci(fib));

        double base = 2;
        int exponent = 3;
        System.out.println("Problem 5: Power of " + base + " raised to " + exponent + ": " + power(base, exponent));

        int[] nums = {5, 1, 1, 2, 0, 0};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println("Problem 6: Merge Sort: " + Arrays.toString(nums));

        int[] sortedArray = {1, 3, 5, 7, 9};
        int target = 7;
        System.out.println("Problem 7: Binary Search for " + target + ": Index " + binarySearch(sortedArray, target));

        int[] permuteArray = {1, 2, 3};
        System.out.println("Problem 8: Permutations: " + permute(permuteArray));

        int[] subsetArray = {1, 2, 3};
        System.out.println("Problem 9: Subsets: " + subsets(subsetArray));

        int[] candidates = {2, 3, 6, 7};
        int targetSum = 7;
        System.out.println("Problem 10: Combination Sum for " + targetSum + ": " + combinationSum(candidates, targetSum));
    }
}
