import java.util.*;
 import java.io.*;
public class NumberOfRotations {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
               int n=sc.nextInt();
               int arr[]=new int[n];
                for(int i=0;i<n;i++){ 
              arr[i]=sc.nextInt();
         }
         System.out.println(findMin(arr));
                
sc.close();
    }
    public static int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]<nums[high]){
               high=mid;
            }else{
                low=mid+1;
            }
            }
            return low;
        }
}