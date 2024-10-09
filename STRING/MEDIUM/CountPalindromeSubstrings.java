class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            // Count odd-length palindromes (single center)
            count += countPalindromesAroundCenter(s, i, i, n);
            
            // Count even-length palindromes (two centers)
            count += countPalindromesAroundCenter(s, i, i + 1, n);
        }
        
        return count;
    }
    
    // Helper function to count palindromes centered at left and right
    private int countPalindromesAroundCenter(String s, int left, int right, int n) {
        int count = 0;
        
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            count++;  // Found a palindrome
            left--;   // Expand to the left
            right++;  // Expand to the right
        }
        
        return count;
    }
}
