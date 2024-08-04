class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int count=0;
        String s=strs[0];
        String s1=strs[strs.length-1];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==s1.charAt(i))
            count++;
            else
            break;

    
        }
    if(count>0){
        return(s.substring(0, count));
    }
    else
    return("");
    }

}