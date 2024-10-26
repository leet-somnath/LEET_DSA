import java.util.Stack;

public class RemoveKDIgitsToFormSmallNumber {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < num.length(); i++) {
			char ch = num.charAt(i);
			if(k==0)
			{
				stack.push(ch);  // k is 0 no way we can pop
			}
			else
			{
				if(stack.size()==0)   // stack is empty, so we have to push anyway even if we have k
				{
					stack.push(ch);
				}
				else  // stack is not empty, gotta peek
				{
				     while(stack.size()>0 && stack.peek()>ch && k>0)
				     {
				    	 stack.pop();
				    	 k--;
				     }
				     stack.push(ch);
				    
				}
			}
		}
        
        // now check if we still have k
        while(k>0)
        {
        	if(stack.size()>0)
        	{
        		stack.pop();
        		k--;
        	}
        	else
        	{
        		break;
        	}
        }
        if(stack.size()==0)return "0";
        StringBuilder sb = new StringBuilder();
        boolean stillZero = true;
        for (Character c : stack) {
        	if(sb.length()==0 && c=='0')continue;
            sb.append(c);
        }
        if(sb.toString().equals("")) return "0";
		return sb.toString();
    }
} {
    
}
