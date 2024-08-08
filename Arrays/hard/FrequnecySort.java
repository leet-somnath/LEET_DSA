import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            
            // Count frequency of each element
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int num : arr) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
            
            // Sort the array based on frequency and then by value
            List<Integer> sortedList = new ArrayList<>();
            for (int num : arr) {
                sortedList.add(num);
            }
            
            Collections.sort(sortedList, new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    int freqA = frequencyMap.get(a);
                    int freqB = frequencyMap.get(b);
                    
                    if (freqA != freqB) {
                        return Integer.compare(freqA, freqB);
                    } else {
                        return Integer.compare(a, b);
                    }
                }
            });
            
            // Print the sorted elements
            for (int num : sortedList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}
