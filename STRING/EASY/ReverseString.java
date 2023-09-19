/*
 * Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
 */

import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
char ch[]=new char[n];
for (int i = 0; i < ch.length; i++) {
    ch[i]=sc.next().charAt(0);
   
}
 reverse(ch);//mehod-1 using two pointer technique
    System.out.println(Arrays.toString(ch));
    reverse2(ch);//using string Buffer
    System.out.println(Arrays.toString(ch));
sc.close();
    }
    public static  void reverse(char ch[]){
        int i=0;
        int j=ch.length-1;
        while(i<j){
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }
    }
    public static void reverse2(char ch[]){
        StringBuffer s=new StringBuffer();
        s.append(ch);
        s.reverse();
        s.getChars(0, s.length(), ch, 0);
    }
    
}