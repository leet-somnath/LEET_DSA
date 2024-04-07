/*
 * Given an array of unique integer elements, print all the subsets of the given array in lexicographical order.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the size of the array and second line contains the elements of the array.

Constraints

1 <= T <= 100
1 <= N <= 10
0 <= A[i] <= 100

Output Format

For each test case, print the subsets of the given array in lexicographical order, separated by new line. Print an extra newline between output of different test cases.

Sample Input 0

3
3
5 15 3 
2
57 96 
4
3 15 8 23 
Sample Output 0

3 
3 5 
3 5 15 
3 15 
5 
5 15 
15 

57 
57 96 
96 

3 
3 8 
3 8 15 
3 8 15 23 
3 8 23 
3 15 
3 15 23 
3 23 
8 
8 15 
8 15 23 
8 23 
15 
15 23 
23 
Explanation 0

Self Explanatory `
 */
import java.io.*;
import java.util.*;

public class SUbsetGeneration {
  
    
    static Comparator<ArrayList<Integer>> comparator = new Comparator<ArrayList<Integer>>() {
        @Override
        public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
            int size = Math.min(list1.size(), list2.size());
            for (int i = 0; i < size; i++) {
                int compareValue = list1.get(i).compareTo(list2.get(i));
                if (compareValue != 0) {
                    return compareValue;
                }
            }
            return Integer.compare(list1.size(), list2.size());
        }
    };
  
    public static void subset(int[] arr,int n) {
        List<ArrayList<Integer>> subsets = new ArrayList<>();
        
        for(int i=1;i<(1<<n);i++) {
            ArrayList<Integer> x = new ArrayList<>();
            for(int j=0;j<n;j++) {
                if((i&(1<<j))!=0)
                    x.add(arr[j]);
            }
            Collections.sort(x);
            subsets.add(x);
        }
        
        Collections.sort(subsets, comparator);
        for(List<Integer> m: subsets)
        {
for(int k:m)
{
    System.out.print(k+" ");
}
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            subset(arr, n);
            System.out.println();
        }
    }
}
