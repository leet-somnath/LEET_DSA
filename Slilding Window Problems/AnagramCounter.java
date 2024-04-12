import java.util.Arrays;

public class AnagramCounter {

    public static int countAnagrams(String str, String pattern) {
        int n = str.length();
        int k = pattern.length();

        if (n < k) return 0; // If pattern is longer than string, no anagrams possible

        int[] count_s = new int[256];
        int[] count_p = new int[256];

        // Populate count array for pattern p
        for (char c : pattern.toCharArray()) {
            count_p[c - 'a']++;
        }

        int i = 0;
        int j = 0;
        int count = 0;

        while (j < n) {
            // Expand the window by moving j pointer
            count_s[str.charAt(j) - 'a']++;

            // If window size is equal to pattern size
            if (j - i + 1 == k) {
                // Compare current window of s with pattern p
                if (Arrays.equals(count_s, count_p)) {
                    count++;
                    // to find the anagram u can store index i in a list
                }

                // Slide the window by moving i pointer
                count_s[str.charAt(i) - 'a']--;
                i++;
            }

            j++;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        int result = countAnagrams(s, p);
        System.out.println("Number of anagrams of pattern in string: " + result); // Output: 2
    }
}
