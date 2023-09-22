import java.util.*;
public class LongestPrefixPalindrome {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
String s=sc.nextLine();
int i=0;
while(palindrome(s.substring(0, i)))
{
    
    i++;
}
System.out.println(s.substring(0, i));
    }
    public static boolean palindrome(String s)
    {
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}