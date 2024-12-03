class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        int k = words[0].length() * words.length;
        int z = words[0].length();
        int i = 0, j = 0;
        while (j < s.length()) {
            if (j - i + 1 == k) {
                String sub = s.substring(i, j + 1);
                HashMap<String, Integer> map2 = new HashMap<>();
                int p = 0;
                while (p < sub.length()) {
                    String temp = sub.substring(p, p + z);
                    map2.put(temp,map2.getOrDefault(temp,0)+1);
                    p +=z;
                }
                if (map.equals(map2)){
                    ans.add(i);
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}