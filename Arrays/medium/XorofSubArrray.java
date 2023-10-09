import java.util.*;

public class XorofSubArrray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for (int i = 0; i < n; i++) { 
            arr[i] = sc.nextInt();
        }
        
        List<List<Integer>> subsets = subset(arr, n);
        int sumOfXORs = calculateSumOfXORs(subsets);
        
        System.out.println("Sum of all XORs: " + sumOfXORs);
        
        sc.close();
    }
    
    public static List<List<Integer>> subset(int[] arr, int n) {
        List<List<Integer>> subsets = new ArrayList<>();
        
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }
            
            subsets.add(subset);
        }
        
        return subsets;
    }
    
    public static int calculateSumOfXORs(List<List<Integer>> subsets) {
        int xor = 0;
        
        for (List<Integer> subset : subsets) {
            int subsetXOR = 0;
            
            for (int num : subset) {
                subsetXOR ^= num;
            }
            
            xor ^= subsetXOR;
        }
        
        return xor;
    }
}