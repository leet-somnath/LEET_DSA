import java.util.*;
public class A_Way_Too_Long_Words
{
          public static void main(String args[])
{
       Scanner sc=new Scanner(System.in);
       int t=sc.nextInt();
       while(t-->0){

       
       String s=sc.next();
       if(s.length()<=10)
         System.out.println(s);
       else
{
  StringBuffer s2=new StringBuffer();
  s2.append(s.charAt(0));
s2.append(s.length()-2);
s2.append(s.charAt(s.length()-1));
System.out.println(s2);
}
}}
}