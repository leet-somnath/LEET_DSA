import java.util.*;

public class SubsetGEneratorandSumofThemToo {

    static void generateSubsequencesHelper(int ind, ArrayList<Integer> arr, int N, ArrayList<Integer> currentSubset,
            ArrayList<Integer> subsetSums, int sum) {
        if (ind == N) {
            if (!currentSubset.isEmpty()) { // Exclude the empty subset
                subsetSums.add(sum); // Add the sum of the current subsequence to the list of subset sums
            }
            return;
        }

        // Include the element at index 'ind' in the current subsequence
        currentSubset.add(arr.get(ind));
        generateSubsequencesHelper(ind + 1, arr, N, currentSubset, subsetSums, sum + arr.get(ind));

        // Exclude the element at index 'ind' from the current subsequence
        currentSubset.remove(currentSubset.size() - 1); // Backtrack: remove the last element from the current
                                                        // subsequence
        generateSubsequencesHelper(ind + 1, arr, N, currentSubset, subsetSums, sum);
    }

    static ArrayList<Integer> generateSubsequences(ArrayList<Integer> arr) {
        ArrayList<Integer> subsetSums = new ArrayList<>();
        generateSubsequencesHelper(0, arr, arr.size(), new ArrayList<>(), subsetSums, 0);
        Collections.sort(subsetSums); // Sort the subset sums in increasing order
        return subsetSums;
    }

    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);

        ArrayList<Integer> subsetSums = generateSubsequences(arr);

        System.out.println("Subsequence sums in increasing order:");
        for (int sum : subsetSums) {
            System.out.print(sum + " ");
        }
    }
}
