import java.util.*;
public class BalnacedParenthisisversion2 {
    
        public static String isBalanced(String s) {
            Deque<Character> x=new ArrayDeque<>();
              for (int i = 0; i < s.length(); i++) {
                  char c=s.charAt(i);
                  if(c=='(' || c=='{' || c=='[')
                     x.push(c);
                  else
                  {
                      if(x.isEmpty()==true)
                      return "NO";
                      else if(balance(x.peek(), c)==false)
                      return "NO";
                      else
                      x.pop();
                  }
              }
              return (x.isEmpty()==true?"YES":"NO");
          }
           public static boolean balance(char a,char b)
          {
              return (a=='(' && b==')' || a=='{'&& b=='}' || a=='['&& b==']');
          }
}