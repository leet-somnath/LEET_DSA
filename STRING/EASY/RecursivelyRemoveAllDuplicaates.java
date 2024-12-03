class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(st.size()==0)
                st.push(ch);
            else if(st.peek()==ch)
                st.pop();
            else
                st.push(ch);
        }
        String ans = "";
        while(st.size() > 0){
            char ch = st.pop();
            ans = ch + ans;
        }
        return ans;       

    }
}