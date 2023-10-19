import java.util.*;
 import java.io.*;
public class ReverseArray {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
               int n=sc.nextInt();
               int arr[]=new int[n];
                for(int i=0;i<n;i++){ 
              arr[i]=sc.nextInt();
         }
         int i=0;
                reversearray(i,arr);
                System.out.println(Arrays.toString(arr));
sc.close();
    }
    public static void reversearray(int i,int arr[]){
        if(i==arr.length/2){
            return;
        }
            else
            {
                int temp=arr[i];
                arr[i]=arr[arr.length-1-i];
                arr[arr.length-1-i]=temp;
                reversearray(i+1,arr);
            }
    }
}