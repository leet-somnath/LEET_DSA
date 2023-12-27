import java.util.*;
 import java.io.*;
public class A_Petya_and_Strings {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
String s1=sc.next();
String s2=sc.next();
int res=s1.compareToIgnoreCase(s2);
if(res==0)
System.out.println("0");
else if(res>0)
System.out.println(1);
else
System.out.println(-1);
sc.close();
    }
}