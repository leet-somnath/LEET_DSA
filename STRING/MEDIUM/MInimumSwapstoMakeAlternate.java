class Solution {
    public int minSwaps(String s) {
     int one = 0, zero = 0;
     for (char ch : s.toCharArray()) {
         if (ch == '1') one++;
         else zero++;
     }
     if (Math.abs(one - zero) > 1)
         return -1;
     if (one > zero)
         return checkSwaps(s.toCharArray(), '1');
     else if (zero > one)
         return checkSwaps(s.toCharArray(), '0');
     else
         return Math.min(checkSwaps(s.toCharArray(), '1'), checkSwaps(s.toCharArray(), '0'));
 }
 
 public int checkSwaps(char[] s, char symbol) {
     int swaps = 0;
     for (int i = 0; i < s.length; i++) {
         if (s[i] == symbol && i % 2 != 0)
             swaps++;
     }
     return swaps;
 }
 
 }