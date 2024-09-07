
class Solution {
    public int maxDepth(String s) {

        int n = s.length();
        int para = 0;
        int count = 0;

        for(int i =0;i<n;i++)
        {
            if(s.charAt(i)=='(')
            {
                para++;
            }
            count = Math.max(para,count);

            if(s.charAt(i)==')')
            {
                para--;
            }
        }
        return count;
    }
}
/*
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
 */