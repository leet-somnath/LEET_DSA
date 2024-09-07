import java.util.HashMap;

class Solution {
    public int countSubstringsWithKDistinct(String s, int k) {
        return countSubstringsAtMostKDistinct(s, k) - countSubstringsAtMostKDistinct(s, k - 1);
    }

    private int countSubstringsAtMostKDistinct(String s, int k) {
        if (k == 0) return 0;

        HashMap<Character, Integer> freqMap = new HashMap<>();
        int left = 0, right = 0, count = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);

            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }
}
