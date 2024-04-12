import java.util.*;
 import java.io.*;
public class A_Halloumi_Boxes {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
        int t=sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int k=sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int c=0;
            for (int i = 0; i < arr.length; i++) {
                if(i==0)
                {
                    if(arr[i]<=arr[n-1] || arr[i]<arr[i+1])
                    c++;
                }
                else
                {
                    if(i!=n-1)
                    if(arr[i]<=arr[i+1] || arr[i]>=arr[i-1])
                    c++;
                    
                if(i==n-1 && (arr[i]>=arr[i-1] || arr[i]>=arr[0])) 
                c++;
                }
            }
            System.out.println((n-c)<=k?"YES":"NO");
        }
sc.close();
    }
}