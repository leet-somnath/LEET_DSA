class Solution {
    private int[] x = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); ++i) x[order.charAt(i) - 'a'] = i;
        for (int i = 0; i < words.length; ++i) {
            for (int j = i + 1; j < words.length; ++j) {
                String a = words[i], b = words[j];
                int ml = Math.max(a.length(), b.length());
                for (int m = 0; m < ml; ++m) {
                    int p = a.length() > m ? x[a.charAt(m) - 'a'] : -1;
                    int q = b.length() > m ? x[b.charAt(m) - 'a'] : -1;
                    if (p < q) break;
                    if (p > q) return false;
                }
            }
        }
        return true;
    }
}