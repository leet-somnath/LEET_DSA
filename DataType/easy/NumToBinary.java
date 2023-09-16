/*

Given an integer, find its 32-bit binary representation without using built-in functions.

Input:  20
Output: "00000000000000000000000000010100"

Input:  64
Output: "00000000000000000000000001000000"

Input:  127
Output: "00000000000000000000000001111111"

Input:  -1
Output: "11111111111111111111111111111111"

*/

//solution:-
 //method -1: Recursive approach

 package DataType;

import java.util.Scanner;

public class NumToBinary {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int res=toBinary(x);
        System.out.println(res);
        
    }
    public static int toBinary(int x){
        if(x==0){
            return 0;
        }
        return x%2+10*toBinary(x/2);
    }
}

//method -2: using while loop

/*
package DataType;

import java.util.Scanner;

public class NumToBinary {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int res = toBinary(x);
        System.out.println(res);
    }

    public static int toBinary(int x) {
        int binary = 0;
        int base = 1;

        while (x > 0) {
            int remainder = x % 2;
            binary += remainder * base;
            x /= 2;
            base *= 10;
        }

        return binary;
    }
} */

//method-3:-(built in method)
/*
 
package DataType;

public class NumToBinary {
    public static void main(String args[])
    {
        int a=10;
        System.out.println(Integer.toBinaryString(a));
    }
}
 */
