
import java.util.*;
 import java.io.*;
public class DecimalTOBInary {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
        int n=sc.nextInt();
        for(int i=31;i>=0;i--)
        {
            int k=n>>i;
            System.out.println(n);
            if(((k)&1 )==1)
            System.out.print(1);
            else
            System.out.print(0);
        }
sc.close();
    }
}


/*
 * public class Solution {
    public String findDigitsInBinary(int A) {
        int rem=0;
        StringBuffer binary=new StringBuffer();
        
        if(A==0)
        return "0";
    while(A>0)
    {
        rem=A%2;
        binary.append(rem);
        A/=2;
        
    }
    return binary.reverse().toString();
    }
    
}
 */