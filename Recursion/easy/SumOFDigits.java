/*
 * Given a number, find the sum of its digits.

Examples : 

Input: n = 687
Output: 21

Input: n = 12
Output: 3
 */

 import java.util.*;
  import java.io.*;
 public class SumOFDigits {
    public static void main(String[] args) {
 Scanner sc=new Scanner(System.in);
                
    int n=sc.nextInt();
    System.out.println(sumofdigits(n));
 sc.close();
    }


    public static int sumofdigits(int n){
        
           if(n==0)
           return 0;

        return (n%10)+sumofdigits(n/10);
    }
 }