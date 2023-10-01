/*

Given a circularly sorted array of distinct integers, find the total number of times the array is rotated. You may assume that the rotation is in anti-clockwise direction.

Input: [8, 9, 10, 2, 5, 6]
Output: 3

Input: [2, 5, 6, 8, 9, 10]
Output: 0

*/
import java.util.*;
 import java.io.*;
public class RotationCount {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
               int n=sc.nextInt();
               int arr[]=new int[n];
                for(int i=0;i<n;i++){ 
              arr[i]=sc.nextInt();
         }
               
sc.close();
    }
}