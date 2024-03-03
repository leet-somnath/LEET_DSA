import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t!=0){
            t--;
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]=sc.nextInt();
                }
            }
            for(int g=n-1;g>=0;g--){
                int sum=0;
                for(int i=0,j=g;j<n;i++,j++){
                    sum+=a[i][j];
                }
                System.out.print(sum+" ");
            }
            for(int g=1;g<n;g++){
                int sum=0;
                for(int i=g,j=0;i<n;i++,j++){
                    sum+=a[i][j];
                }
                System.out.print(sum+" ");
            }
            System.out.println();
        }
    }
}