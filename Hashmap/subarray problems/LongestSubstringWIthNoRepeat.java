class Solution {
    public int lengthOfLongestSubstring(String str) {
         int maxlen=0;
        HashMap<Character,Integer> map=new HashMap<>();
                    int i=0,j=0;
        while(j<str.length())
        {
            char currentChar=str.charAt(j);
            if(map.containsKey(currentChar))
            {

                i=Math.max(map.get(currentChar)+1,i);
            }
            maxlen=Math.max(j-i+1,maxlen);
                map.put(currentChar, j);
            
            j++;
            
        }
        return maxlen;
    }
}