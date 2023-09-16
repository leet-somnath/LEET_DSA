/*Print unique elements of the array in the same order as they appear in the input.
Note: Do not use any inbuilt functions/libraries for your main logic.

Input Format

First line of input contains a single integer N - the size of array and second line contains array elements.

Constraints

1 <= N <= 100
0 <= ar[i] <= 109

Output Format

Print unique elements of the array. */


package Arrays.easy;

import java.util.HashMap;
import java.util.Scanner;

public class UniqueElement {
    public static void main(String args[]){
           Scanner sc=new Scanner(System.in);
           int N=sc.nextInt();
           int x[]=new int[N];
           for(int i=0;i<N;i++){
               x[i]=sc.nextInt();
           }
           HashMap<Integer,Integer> map=new HashMap<>();
           for(int i=0;i<N;i++){
               map.put(x[i],map.getOrDefault(x[i],0 )+1);
           }
           for(int t :  x){
               if(map.get(t)==1){
                   System.out.print(t+" ");
               }
           }
    }
    
}
