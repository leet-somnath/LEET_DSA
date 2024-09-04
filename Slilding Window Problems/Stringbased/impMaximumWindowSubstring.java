// Given two strings s and t of lengths m and n respectively, 
// return the maximum window substring of s such that every character in t (including duplicates) is included in the window. 
// If there is no such substring, return the empty string "".

public class IMPMaximumWindowSubstring  {

    public static String maxWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] countS = new int[128];
        int[] countT = new int[128];

        // Populate count array for pattern t
        for (char c : t.toCharArray()) {
            countT[c]++;
        }

        int start = 0, end = 0;
        int size = Integer.MIN_VALUE;
        int i = 0, j = 0;
        int requiredChars = t.length();
        int formedChars = 0;

        while (j < n) {
            char ch = s.charAt(j);
            countS[ch]++;

            if (countT[ch] > 0 && countS[ch] <= countT[ch]) {
                formedChars++;
            }

            while (formedChars == requiredChars) {
                // Update the maximum window size if larger
                if (j - i + 1 > size) {
                    size = j - i + 1;
                    start = i;
                    end = j + 1;
                }

                // Shrink the window from the left
                char leftChar = s.charAt(i);
                countS[leftChar]--;
                if (countT[leftChar] > 0 && countS[leftChar] < countT[leftChar]) {
                    formedChars--;
                }
                i++;
            }
            j++;
        }

        return size == Integer.MIN_VALUE ? "" : s.substring(start, end);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = maxWindow(s, t);
        System.out.println("Maximum window substring: " + result); // Output: "BANC"
    }
}
