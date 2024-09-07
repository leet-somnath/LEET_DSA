import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Max {
    
    // Function to find the type of dish with maximum length of non-adjacent subsequence
    public static int maxDishesType(int N, int[] A) {
        // Step 1: Use a HashMap to store indices for each dish type
        Map<Integer, List<Integer>> dishMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            dishMap.putIfAbsent(A[i], new ArrayList<>());
            dishMap.get(A[i]).add(i);
        }

        int maxLength = 0;
        int resultType = Integer.MAX_VALUE;

        // Step 2: Use dynamic programming to calculate the max subsequence length for each type
        for (Map.Entry<Integer, List<Integer>> entry : dishMap.entrySet()) {
            int dishType = entry.getKey();
            List<Integer> indices = entry.getValue();
            
            int[] dp = new int[indices.size()];
            dp[0] = 1;

            // Fill DP array ensuring no two adjacent indices are picked
            for (int i = 1; i < indices.size(); i++) {
                if (indices.get(i) - indices.get(i - 1) > 1) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1];
                }
            }

            int maxForType = dp[dp.length - 1];

            // Step 3: Check for the maximum length and select the smallest type if there's a tie
            if (maxForType > maxLength) {
                maxLength = maxForType;
                resultType = dishType;
            } else if (maxForType == maxLength) {
                resultType = Math.min(resultType, dishType);
            }
        }

        return resultType;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        // Example usage
         int n=sc.nextInt();
         int arr[]=new int[n];
          for(int i=0;i<n;i++){ 
        arr[i]=sc.nextInt();
   }
          
        
        // Output the result
        System.out.println(maxDishesType(n, arr));  // Output: 1
    }
}
