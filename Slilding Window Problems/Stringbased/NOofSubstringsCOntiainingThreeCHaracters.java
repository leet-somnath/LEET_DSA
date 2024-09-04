class Solution {
    public int numberOfSubstrings(String s) {
        int cnt = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;

        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            if (map.size() == 3) {
                cnt += s.length() - j;
            }

            while (i <= j && map.size() == 3) {
                char ch = s.charAt(i);
                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    map.remove(ch);
                }

                i++;

                if (map.size() == 3) {
                    cnt += s.length() - j;
                }
            }
            j++;
        }

        return cnt;
    }
}
