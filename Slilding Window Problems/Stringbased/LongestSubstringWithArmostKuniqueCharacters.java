import java.util.HashMap;

public class LongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int maxLen = 0;
        
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while (map.size() > k) {
                char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) map.remove(leftChar);
                i++;
            }
            
            maxLen = Math.max(maxLen, j - i + 1);
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
        LongestSubstringKDistinct solution = new LongestSubstringKDistinct();
        String s = "eceba";
        int k = 2;
        System.out.println("Length of the longest substring with at most " + k + " distinct characters: " + solution.lengthOfLongestSubstringKDistinct(s, k));
    }
}
/*
 * public class LongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;

        int[] count = new int[256]; // Assuming ASCII characters

        int distinctCount = 0;
        int maxLen = 0;
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (count[c] == 0) distinctCount++;
            count[c]++;

            while (distinctCount > k) {
                char leftChar = s.charAt(i);
                count[leftChar]--;
                if (count[leftChar] == 0) distinctCount--;
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringKDistinct solution = new LongestSubstringKDistinct();
        String s = "eceba";
        int k = 2;
        System.out.println("Length of the longest substring with at most " + k + " distinct characters: " + solution.lengthOfLongestSubstringKDistinct(s, k));
    }
}

 */