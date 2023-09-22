import java.util.*;
public class StringPalindrome {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
String s=new String(sc.next());
String s1=new StringBuffer(s).reverse().toString();
if(s.equals(s1))
System.out.println("palindrome");        
else
System.out.println("not");










sc.close();
    }
}