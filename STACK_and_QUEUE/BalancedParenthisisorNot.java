

import java.util.*;
import java.io.*;

public class BalancedParenthisisorNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        System.out.println(valid(s));
        sc.close();
    }
    public static boolean valid(String s)
    {
        Deque<Character> x=new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='(' || c=='{' || c=='[')
               x.push(c);
            else
            {
                if(x.isEmpty()==true)
                return false;
                else if(balance(x.peek(), c)==false)
                return false;
                else
                x.pop();
            }
        }
        return (x.isEmpty()==true);
    }
    public static boolean balance(char a,char b)
    {
        return (a=='(' && b==')' || a=='{'&& b=='}' || a=='['&& b==']');
    }
}