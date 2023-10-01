import java.util.*;
 import java.io.*;
public class ArrayCountingBits {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
        int n=sc.nextInt();
        int arr[]=new int[n];
        arr=countBits(n);
        System.out.println(Arrays.toString(arr));
sc.close();
    }
    public static int[]  countBits(int n) {
        int[] a = new int[n+1];
        for (int i = 0; i <= n; i++) {
            a[i] = countbit(i);
        }
        return a;
    }
    
    public static int countbit(int n) { 
        int count = 0;
        for (int i = 31; i >= 0; i--) {
          
            if((n&(1<<i))!=0) {
                count++;
            }
        }
        return count;
    }

}