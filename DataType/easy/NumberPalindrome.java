/*Palindrome Number
Category	Difficulty	Likes	Dislikes
algorithms	Easy (53.92%)	10039	2534
Tags
Companies
Given an integer x, return true if x is a palindrome, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 

Follow up: Could you solve it without converting the integer to a string?
Discussion | Solution

Code Now */


package DataType;

import java.util.Scanner;

public class NumberPalindrome {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        if(x<0)
        System.out.println("false");
        else{
            int rev=0;
            int temp=x;
            while(x>0){
                rev=rev*10+x%10;
                x=x/10;
            }
            if(rev==temp)
            System.out.println("true");
            else
            System.out.println("false");
        }
    }
}
