class Solution {
    public int repeatedStringMatch(String a, String b) {
    StringBuilder gy=new StringBuilder();
        int I=0;
    for(I=1; gy.length()<=b.length(); I++){
        gy.append(a);
        if(gy.toString().contains(b))return I;
    }
        if(gy.append(a).toString().contains(b))return I;
        return -1;
    }
}
//https://leetcode.com/problems/repeated-string-match/description/