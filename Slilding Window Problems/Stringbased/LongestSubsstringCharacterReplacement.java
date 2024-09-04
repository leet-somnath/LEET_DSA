class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int length = 0;
        int max = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            count[s.charAt(j) - 'A']++;
            max = Math.max(max, count[s.charAt(j) - 'A']);
            if (j - i + 1 - max > k) {
                count[s.charAt(i) - 'A']--;
                i++;
            }
            length = Math.max(length, j - i + 1);
            j++;
        }
        return length;
    }
}
