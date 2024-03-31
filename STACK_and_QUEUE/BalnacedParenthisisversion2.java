import java.util.*;
public class BalnacedParenthisisversion2 {
    public int solve(String A) {
        Deque<Character> sk = new ArrayDeque<>(); // Using Deque instead of Stack
        if(A.length()==1)
        {
            return 0;
        }
       for(char st:A.toCharArray())
       {
           if(st=='(')
           {
               sk.push(st);
           }  
       
        else if(st==')' && !sk.isEmpty())
        {
            sk.pop();
         
        }
         else if(st==')' && sk.isEmpty())
        {
           return 0;
         
        }
       
       }
       if(sk.isEmpty())
        {
            return 1;
        }
        else{
            return 0;
        }
       
       
       
       
         
     
    }
}