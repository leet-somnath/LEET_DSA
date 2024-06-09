import java.util.*;

public class NoofValidSubarrays {
    
    public static int countSubarrays(int[] arr) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        
        sumMap.put(0, 1);
        
        for (int num : arr) {
            if (num == 1) {
                sum += 1;
            } else {
                sum -= 1;
            }
            
            if (sumMap.containsKey(sum)) {
                count += sumMap.get(sum);
                sumMap.put(sum, sumMap.get(sum) + 1);
            } else {
                sumMap.put(sum, 1);
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            
            System.out.println(countSubarrays(arr));
        }
        
        sc.close();
    }
}
