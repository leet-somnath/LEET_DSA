import java.util.*;
import java.io.*;

public class A_Helpful_Maths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        char arr[]=new char[s.length()];
       int k=0;
        for(int i=0;i<s.length();i++)
           {
            if(Character.isDigit(s.charAt(i)))
                arr[k++]=s.charAt(i);
           }
        Arrays.sort(arr);
        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(arr[i]))
            {
                if(i!=s.length()-1)
                System.out.print(arr[i]+"+");
                else
                System.out.println(arr[i]);
            }
        }
        sc.close();
    }
}