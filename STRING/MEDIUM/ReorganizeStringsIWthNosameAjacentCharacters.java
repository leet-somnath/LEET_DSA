class Solution {
    public String reorganizeString(String s) {
        int [] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int maxCount = 0;
        int letter = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                letter = i;
            }
        }

        if (maxCount > (s.length() + 1) / 2)
            return "";

        char [] ans = new char[s.length()];
        int index = 0;

        //place the most freq letter
        while (count[letter] != 0) {
            ans[index] = (char) (letter + 'a');
            index += 2;
            count[letter]--;
        }

        //place the rest of the letters in any order
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (index >= s.length())
                    index = 1;
                ans[index] = (char) (i + 'a');
                index += 2;
                count[i]--;
            }
        }

        return String.valueOf(ans);
        
    }
}
