import java.util.*;
 import java.io.*;
public class AllSubarray {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
               int n=sc.nextInt();
               int arr[]=new int[n];
                for(int i=0;i<n;i++){ 
              arr[i]=sc.nextInt();
         }
                subset(arr,n);
sc.close();
    }
    public static void subset(int[] arr,int n)
    {
        List<List<Integer>> subsets = new ArrayList<>();
        
        for(int i=0;i<(1<<n);i++)
        {
            List<Integer> x=new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                if((i&(1<<j))!=0)
               x.add(arr[j]);
            }
           subsets.add(x);
        }
        System.out.println(subsets.toString());
    }
}